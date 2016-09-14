package model;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Seracher;
import algorithms.search.Solution;
import controller.Controller;


public interface Model {
	void generateMaze (String name, int floors, int rows, int cols);
	Maze3d getMaze (String name);
	void exit();
	void setController(Controller controller);
	void setMaze (String name, Maze3d maze);
	void solveMaze (String name, Seracher algorithm);
	public Solution getSolution (String name);
}

