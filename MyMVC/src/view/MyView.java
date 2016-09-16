package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import controller.Command;
import controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class MyView.
 */
public class MyView extends CommonView {

	/**
	 * Instantiates a new my view.
	 *
	 * @param in
	 *            the in
	 * @param out
	 *            the out
	 */
	public MyView(BufferedReader in, PrintWriter out) {
		super(in, out);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.CommonView#setController(controller.Controller)
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.CommonView#notifyMazeIsReady(java.lang.String)
	 */
	@Override
	public void notifyMazeIsReady(String name) {
		out.println("The Maze " + name + " is ready");
		out.flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.CommonView#displayMaze(algorithms.mazeGenerators.Maze3d)
	 */
	@Override
	public void displayMaze(Maze3d maze) {
		out.println(maze);
		out.flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.CommonView#setCommands(java.util.HashMap)
	 */
	@Override
	public void setCommands(HashMap<String, Command> commands) {
		cli.setCommand(commands);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.CommonView#printAnswers(java.lang.String[])
	 */
	@Override
	public void printAnswers(String[] args) {
		for (String line : args) {
			// prints filename and directory name
			out.println(line);
			out.flush();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.CommonView#start()
	 */
	@Override
	public void start() {
		cli.start();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.CommonView#printCrossSection(int[][])
	 */
	@Override
	public void printCrossSection(int[][] maze2d) {
		for (int[] i : maze2d) {
			for (int j : i) {
				out.print(j + " ");
			}
			out.println("");
		}
		out.println("");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.View#notifyMazeWasSolved(java.lang.String)
	 */
	@Override
	public void notifyMazeWasSolved(String name) {
		out.println("Solution for " + name + " is ready");
		out.flush();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.View#displaySolution(algorithms.search.Solution)
	 */
	public void displaySolution(Solution<Position> sol) {
		out.println("");
		out.println("************** \n The Solution for the maze is: ");
		out.println(sol);
		out.println("");
		out.flush();
	}

	@Override
	public void notifyProgramIsAboutToEnd() {
		out.println("Bye Bye :) ");
		out.flush();
	}

	@Override
	public void notifyBadInput() {
		out.println("OOPS, Your input has not the right num of parameters. please try again. for help, press help\n\n");
	}
}
