package view;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import controller.Command;
import controller.Controller;

public class MyView implements View {

	Controller controller;
	
	public MyView(Controller controller) {
		this.controller = controller;
	}
	
	public MyView(){};
	
	void setController (Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void notifyMazeIsReady(String name) {
		// TODO Auto-generated method stub
	}

	@Override
	public void displayMaze(Maze3d maze) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setCommands(HashMap<String, Command> commands) {
		// TODO Auto-generated method stub
	}

	@Override
	public void printAnswers(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
