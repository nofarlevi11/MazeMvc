package boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import controller.Command;
import controller.CommandManager;
import controller.Controller;
import controller.MyController;
import model.Model;
import model.MyModel;
import view.MyView;
import view.View;

public class Run {

	public static void main(String[] args) {
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		View view = new MyView(in, out);
		Model model = new MyModel();
		Controller controller = new MyController(view,model);
		
		view.setController(controller);
		model.setController(controller);
		
//		CommandManager a = new CommandManager(new MyModel(), new MyView(null));
//		Command dir = a.getCommandsMap().get("dir");
//		String[] str= new String[1];
//		str[0]="c:\\";
//		
//		dir.doCommand(str);
		
		view.start();
		
	}

}
