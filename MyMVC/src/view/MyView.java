package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import controller.Command;
import controller.Controller;

public class MyView extends CommonView {

	public MyView(BufferedReader in, PrintWriter out) {
		super(in, out);
	}
	
	public void setController (Controller controller) {
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
		// TODO Auto-generated method stub
	}

	@Override
	public void start() {
		cli.start();
		
	}

}
