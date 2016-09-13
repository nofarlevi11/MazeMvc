package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import controller.Controller;


public class MyModel extends CommonModel {

	
	private List<GenerateMazeRunnable> generateMazeTasks = new ArrayList<GenerateMazeRunnable>();
	
	
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
			GrowingTreeGenerator generator  = new GrowingTreeGenerator();
			Maze3d maze = generator.generate(floors, rows, cols);
			mazes.put(name, maze);
			
			controller.notifyMazeIsReady(name);
		}
		
		public void terminate () {
			generator.setIsDone(true);
		}
	}

	public void setController (Controller controller) {
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
}
