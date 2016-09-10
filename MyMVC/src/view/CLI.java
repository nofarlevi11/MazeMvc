package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CLI {

	private BufferedReader in;
	private PrintWriter out;
	
	private List<Thread> threads = new ArrayList<Thread>();
	
	public CLI(BufferedReader in, PrintWriter out) {
		this.in = in;
		this.out=out;
		
		public void start () {
			Thread thread = new Thread (new Runnable() {
				
				@Override
				public void run() {
					String exit = "exit";
					int inputString = in.read();
					
				}
			});
		}
	}
}
