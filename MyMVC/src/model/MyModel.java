package model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import controller.Controller;

public class MyModel implements Model {

	public MyModel(Controller controller) {
		this.controller = controller;
	}
	private Controller controller;
	private Map<String, Maze3d> mazes = new ConcurrentHashMap<String, Maze3d>(); //hash map for the mazes
	private ExecutorService threadPool;

	@Override
	public void generateMaze(String name, int floors, int rows, int cols) {
		Thread thread = new Thread(new Runnable() {
			

			@Override
			public void run() {
				GrowingTreeGenerator generator  = new GrowingTreeGenerator();
				Maze3d maze = generator.generate (floors, rows, cols);
				mazes.put(name, maze);
				controller.notifyMazeIsReady(name);
			}
		});
		thread.start();
		threadPool.submit(thread);
	}

	@Override
	public Maze3d getMaze(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
