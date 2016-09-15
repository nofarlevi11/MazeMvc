package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import algorithm.demo.MazeAdapter;
import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Seracher;
import algorithms.search.Solution;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;


public class MyModel extends CommonModel {

	
	public MyModel() {
		super();
	}

	class GenerateMazeRunnable implements Runnable {

		private int floors, rows, cols;
		private String name;
		private GrowingTreeGenerator generator;

		public GenerateMazeRunnable(String name, int floors, int rows, int cols) {
			this.name = name;
			this.floors = floors;
			this.rows = rows;
			this.cols = cols;
		}

		@Override
		public void run() {
			GrowingTreeGenerator generator = new GrowingTreeGenerator();
			Maze3d maze = generator.generate(floors, rows, cols);
			mazes.put(name, maze);

			controller.notifyMazeIsReady(name);
		}

		public void terminate() {
			generator.setIsDone(true);
		}
	}
	
	class MazeSolverRunnable implements Runnable {
		
		private String name;
		private Seracher<Position> algorithm;
		
		public MazeSolverRunnable(String name,Seracher<Position> algo) {
			this.name = name;
			this.algorithm = algo;
		}
		
		@Override
		public void run() {
			MazeAdapter myMazeAdap = new MazeAdapter(getMaze(name));
			Solution<Position> sol = algorithm.search(myMazeAdap);
			solutions.put(name, sol);
			
			controller.notifyMazeWasSolved(name);
		}
		
		public void terminate() {
			algorithm.setIsDone(true);
		}
	}

	@Override
	public void generateMaze(String name, int floors, int rows, int cols) {
		GenerateMazeRunnable generateMazeRunnable = new GenerateMazeRunnable(name, floors, rows, cols);
		generateMazeTasks.add(generateMazeRunnable);
		Thread thread = new Thread(generateMazeRunnable);
		thread.start();
		threadPool.submit(thread);
	}

	public void exit() {
		for (GenerateMazeRunnable task : generateMazeTasks) {
			task.terminate();
		}
		for (MazeSolverRunnable task : solverTasks) {
			task.terminate();
		}
	}

	@Override
	public void setMaze(String name, Maze3d maze) {
		//if (!mazes.containsValue(maze))
			mazes.put(name, maze);
	}

	@Override
	public void solveMaze(String name, Seracher<Position> algorithm) {
		MazeSolverRunnable solverRunnable = new MazeSolverRunnable(name, algorithm);
		solverTasks.add(solverRunnable);
		Thread thread = new Thread(solverRunnable);
		thread.start();
		threadPool.submit(thread);
	}
	
	public Solution<Position> getSolution (String name) {
		return solutions.get(name);
	}

	@Override
	public void saveMaze(String name, String path) {
		Maze3d maze = getMaze(name);
		OutputStream out = null;
		try {
			out = new MyCompressorOutputStream(new FileOutputStream(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			out.write(maze.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void loadMaze(String path, String name) {
		InputStream in = null;
		File fileIns = null;
		byte b[] = null;
		try {
			// file instance needed so we could know the size of the maze we
			// are going to load
			fileIns = new File(path);
			in = new MyDecompressorInputStream(new FileInputStream(fileIns));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			b = new byte[(int) fileIns.length() + 1];
			in.read(b);
		} catch (IOException e) {
			// if any error occurs
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// if any error occurs
			e.printStackTrace();
		}

		Maze3d loadedMaze = new Maze3d(b);
		setMaze(name, loadedMaze);
		
	}
}
