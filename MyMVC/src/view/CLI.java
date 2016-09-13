package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import controller.Command;

public class CLI {

	private BufferedReader in;
	private PrintWriter out;

	
	private HashMap<String, Command> commands;

	private List<Thread> threads = new ArrayList<Thread>();

	public CLI(BufferedReader in, PrintWriter out) {
		this.in = in;
		this.out = out;
	}

	public void setCommand(HashMap<String, Command> commands) {
		this.commands = commands;
	}

	private void printMenu() {
		out.println("Please choose command: (");
		for (String command : commands.keySet()) {
			out.println(command + ",");
		}
		out.println(")");
		out.flush();
	}

	public void start() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					printMenu();
					try {
						String commandLine = in.readLine();
						String comArray[] = commandLine.split(" ");
						String command = comArray[0];
						
						
						if (!commands.containsKey(command) && !command.equals("exit")) {
							out.println("command doesn't exist");
							out.println("");
						} else {
							if (command.equals("exit")) {
								break;
							}
							String[] args = null;
							if (comArray.length > 1) {
								String commandArgs = commandLine.substring(commandLine.indexOf(" ") + 1);
								args = commandArgs.split(" ");
							}
							Command cmd = commands.get(command);
							cmd.doCommand(args);
							
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		thread.start();
	}

//	void printAnswers(String[] args) {
//		for (String line : args) {
//			// prints filename and directory name
//			out.println(line);
//			out.flush();
//		}
//	}
}
