package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;
import controller.Controller;
import model.MyModel.GenerateMazeRunnable;
import model.MyModel.MazeSolverRunnable;

// TODO: Auto-generated Javadoc
/**
 * The Class CommonModel.
 */
public abstract class CommonModel implements Model {

	/** The mazes. */
	protected Map<String, Maze3d> mazes = new ConcurrentHashMap<String, Maze3d>(); //hash map for the mazes
	
	/** The controller. */
	protected Controller controller;
	
	/** The thread pool. */
	protected ExecutorService threadPool;
	
	/** The solutions. */
	protected Map <String, Solution> solutions = new ConcurrentHashMap<String, Solution>();
	
	/** The generate maze tasks. */
	protected List<GenerateMazeRunnable> generateMazeTasks = new ArrayList<GenerateMazeRunnable>();
	
	/** The solver tasks. */
	protected List <MazeSolverRunnable> solverTasks = new ArrayList<MazeSolverRunnable>();
	
	/** The open files. */
	protected List<String> openFiles = new ArrayList<String>();
	
	/**
	 * Gets the mazes.
	 *
	 * @return the mazes
	 */
	public Map<String, Maze3d> getMazes() {
		return mazes;
	}

	/**
	 * Instantiates a new common model.
	 */
	public CommonModel() {
		this.mazes = new HashMap<String,Maze3d>();
		this.threadPool = Executors.newCachedThreadPool();
	}
	
	/**
	 * Sets the mazes.
	 *
	 * @param mazes the mazes
	 */
	public void setMazes(Map<String, Maze3d> mazes) {
		this.mazes = mazes;
	}

	/**
	 * Gets the thread pool.
	 *
	 * @return the thread pool
	 */
	public ExecutorService getThreadPool() {
		return threadPool;
	}

	/**
	 * Sets the thread pool.
	 *
	 * @param threadPool the new thread pool
	 */
	public void setThreadPool(ExecutorService threadPool) {
		this.threadPool = threadPool;
	}


	/* 
	 * @see model.Model#getMaze(java.lang.String)
	 */
	@Override
	public Maze3d getMaze(String name) {
		return mazes.get(name);
	}

	/* 
	 * @see model.Model#setController(controller.Controller)
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}

}
