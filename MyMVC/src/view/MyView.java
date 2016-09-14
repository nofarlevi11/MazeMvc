package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;
import controller.Command;
import controller.Controller;

public class MyView extends CommonView {

	public MyView(BufferedReader in, PrintWriter out) {
		super(in, out);
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void notifyMazeIsReady(String name) {
		out.println("The Maze " + name + " is ready");
		out.flush();
	}

	@Override
	public void displayMaze(Maze3d maze) {
		out.println(maze);
		out.flush();
	}

	@Override
	public void setCommands(HashMap<String, Command> commands) {
		cli.setCommand(commands);
	}

	@Override
	public void printAnswers(String[] args) {
		for (String line : args) {
			// prints filename and directory name
			out.println(line);
			out.flush();
		}
	}

	@Override
	public void start() {
		cli.start();

	}

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

	@Override
	public void notifyMazeWasSolved(String name) {
		out.println("Solution for " + name + " is ready");
		out.flush();

	}
	public void displaySolution(Solution sol) {
		out.println ("");
		out.println ("**************");
		out.println("The Solution for the maze is: ");
		out.println(sol);
		out.println("");
		out.flush();
	}
}
