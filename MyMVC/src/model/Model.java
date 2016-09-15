package model;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Seracher;
import algorithms.search.Solution;
import controller.Controller;


public interface Model {
	void generateMaze (String name, int floors, int rows, int cols);
	Maze3d getMaze (String name);
	void exit();
	void setController(Controller controller);
	void setMaze (String name, Maze3d maze);
	void saveMaze (String name, String file);
	void loadMaze (String path, String name);
	void solveMaze (String name, Seracher<Position> algorithm);
	public Solution<Position> getSolution (String name);
}

