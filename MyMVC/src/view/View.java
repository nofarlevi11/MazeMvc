package view;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;
import controller.Command;
import controller.Controller;

public interface View {
	void notifyMazeIsReady(String name);
	void displayMaze (Maze3d maze);
	void setCommands(HashMap<String, Command> commands);
	void start();
	void setController (Controller controller);
	void printAnswers(String[] args);
	void printCrossSection(int[][] maze2d);
	void notifyMazeWasSolved(String name);
	public void displaySolution(Solution maze);
}
