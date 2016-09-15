package controller;

import java.io.File;

import java.util.HashMap;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.BFS;
import algorithms.search.DFS;
import algorithms.search.Seracher;
import algorithms.search.Solution;
import model.Model;
import view.View;

public class CommandManager {

	private Model model;
	private View view;

	public CommandManager(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public HashMap<String, Command> getCommandsMap() {
		HashMap<String, Command> commands = new HashMap<String, Command>();
		commands.put("generate_maze", new GenerateMazeCommand());
		commands.put("display", new DisplayMazeCommand());
		commands.put("dir", new DirCommand());
		commands.put("display_cross_section", new DisplayCrossSectionCommand());
		commands.put("save_maze", new SaveMazeCommand());
		commands.put("load_maze", new LoadMazeCommand());
		commands.put("solve_maze", new SolveMazeCommand());
		commands.put("display_solution", new DisplaySolutionCommand());
		return commands;
	}

	public class GenerateMazeCommand implements Command {
		@Override
		public void doCommand(String[] s) {
			String name = s[0];
			int floors = Integer.parseInt(s[1]);
			int rows = Integer.parseInt(s[2]);
			int cols = Integer.parseInt(s[3]);
			model.generateMaze(name, floors, rows, cols);
		}
	}

	public class DisplayMazeCommand implements Command {

		@Override
		public void doCommand(String[] s) {
			String name = s[0];
			Maze3d maze = model.getMaze(name);
			view.displayMaze(maze);
		}
	}

	public class DirCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			String paths = args[0];
			File folderPath = null;
			String[] filelist;

			try {
				// create new file
				folderPath = new File(paths);

				// array of files and directory
				filelist = folderPath.list();

				view.printAnswers(filelist);
			} catch (Exception e) {
				// if any error occurs
				e.printStackTrace();
			}
		}
	}

	public class DisplayCrossSectionCommand implements Command {
		@Override
		public void doCommand(String[] args) {

			String name = args[0];
			String cross = args[1].toLowerCase(); // the dimension
			String index = args[2];
			Maze3d maze = model.getMaze(name);
			switch (cross) { // checking what dimension the cross will be
			case "z":
				view.printCrossSection(maze.getCrossSectionByZ(Integer.parseInt(index)));
				break;
			case "y":
				view.printCrossSection(maze.getCrossSectionByY(Integer.parseInt(index)));
				break;
			case "x":
				view.printCrossSection(maze.getCrossSectionByX(Integer.parseInt(index)));
				break;
			default:
				break;
			}

		}
	}

	public class SaveMazeCommand implements Command {

		@Override
		public void doCommand(String[] s) {
			String name = s[0];
			String path = s[1];
			model.saveMaze(name, path);
		}
	}

	public class LoadMazeCommand implements Command {

		@Override
		public void doCommand(String[] s) {
			String path = s[0];
			String name = s[1];
			model.loadMaze(path, name);
		};
	}

	public class SolveMazeCommand implements Command {

		@Override
		public void doCommand(String[] s) {
			String name = s[0];
			String algo = s[1];
			Seracher<Position> algorithm = null;
			switch (algo) {
			case "BFS":
				algorithm = new BFS<Position>();
				break;
			case "DFS":
				algorithm = new DFS<Position>();
				break;
			default:
				break;
			}
			model.solveMaze(name, algorithm);
		}
	}

	public class DisplaySolutionCommand implements Command {

		@Override
		public void doCommand(String[] s) {
			String name = s[0];
			Solution<Position> sol = model.getSolution(name); // bring the
																// solution of
																// the maze
																// (according to
																// the name)
																// from the
																// model, to
																// sent to the
																// view
			view.displaySolution(sol); // send the solution to the view, so it
										// could be displayed for the end-user
		}

	}

}
