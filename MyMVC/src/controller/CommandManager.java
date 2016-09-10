package controller;

import model.Model;
import view.View;

public class CommandManager {

	private Model model;
	private View view;
	
	public CommandManager(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	
	
	public class GenerateMazeCommand implements Command{
		@Override
		public void doCommand(String[] s) {
		String name = s[0];
		int floors = Integer.parseInt(s[1]);
		int rows = Integer.parseInt(s[2]);
		int cols = Integer.parseInt(s[2]);
		model.generateMaze(name, floors, rows, cols);
		
		}
	}
	
	public class DisplayMazeCommand implements Command {

		@Override
		public void doCommand(String[] s) {
			// TODO Auto-generated method stub
			
		}
		
		// להשלים מהקוד של רועי!
	}
}
