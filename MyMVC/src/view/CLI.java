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
	
	//רועי
	private HashMap<String, Command> commands;
	
	private List<Thread> threads = new ArrayList<Thread>();
	
	public CLI(BufferedReader in, PrintWriter out) {
		this.in = in;
		this.out=out;
	}
	
	public void setCommand (HashMap<String,Command> commands) {
		this.commands = commands;
	}
	private void printMenu(){
		out.println ("Please choose command: (");
		for (String command : commands.keySet()) {
			out.println(command + ",");
		}
		out.println(")");
		out.flush();
	}

	public void start () {
		Thread thread = new Thread (new Runnable() {
				
			@Override
			public void run() {
					printMenu();
					try {
						String commandLine = in.readLine();
						String arr[] = commandLine.split (" ");
						String command = arr[0];
						
						if (!commands.containsKey(command)) {
							out.println ("command doesn't exist");
						}
						else {
							String[] args = null;
							if (arr.length >1) {
								String commandArgs = commendLine.substring(commandLine.indexOf(" ") + 1);
								args = commandArgs.split(" ");
							}
							Command cmd = commands.get(command);
							cmd.doCommand(args);
							
							if (command.equals("exit")) {
								break;
							}
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					String exit = "exit";
					try {
						int inputString = in.read();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	
	void printAnswers (String[] args){
		for (String line : args) {
			// prints filename and directory name
			out.println(line);
			out.flush();
		}
	}
}
