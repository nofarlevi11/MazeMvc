package model;

import java.util.ArrayList;
import java.util.List;

import algorithm.demo.MazeAdapter;
import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Seracher;
import algorithms.search.Solution;
import controller.Controller;

public class MyModel extends CommonModel {

	private List<GenerateMazeRunnable> generateMazeTasks = new ArrayList<GenerateMazeRunnable>();
	private List <MazeSolverRunnable> solverTasks = new ArrayList<MazeSolverRunnable>();
	
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
		private Seracher algorithm;
		
		public MazeSolverRunnable(String name,Seracher algo) {
			this.name = name;
			this.algorithm = algo;
		}
		
		@Override
		public void run() {
			MazeAdapter myMazeAdap = new MazeAdapter(getMaze(name));
			Solution sol = algorithm.search(myMazeAdap);
			solutions.put(name, sol);
			
			controller.notifyMazeWasSolved(name);
		}
		
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void generateMaze(String name, int floors, int rows, int cols) {
		GenerateMazeRunnable generateMazeRunnable = new GenerateMazeRunnable(name, floors, rows, cols);
		generateMazeTasks.add(generateMazeRunnable);
		Thread thread = new Thread(generateMazeRunnable);
		thread.start();
		threadPool.submit(thread);
	}

	@Override
	public Maze3d getMaze(String name) {
		return mazes.get(name);
	}

	public void exit() {
		for (GenerateMazeRunnable task : generateMazeTasks) {
			task.terminate();
		}
	}

	@Override
	public void setMaze(String name, Maze3d maze) {
		//if (!mazes.containsValue(maze))
			mazes.put(name, maze);
	}

	@Override
	public void solveMaze(String name, Seracher algorithm) {
		MazeSolverRunnable solverRunnable = new MazeSolverRunnable(name, algorithm);
		solverTasks.add(solverRunnable);
		Thread thread = new Thread(solverRunnable);
		thread.start();
		threadPool.submit(thread);
	}
	
	public Solution getSolution (String name) {
		return solutions.get(name);
	}
}
