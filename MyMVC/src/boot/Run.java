package boot;

import controller.Command;
import controller.CommandManager;
import model.MyModel;
import view.MyView;

public class Run {

	public static void main(String[] args) {
		
		CommandManager a = new CommandManager(new MyModel(null), new MyView());
		Command dir = a.getCommandsMap().get("dir");
		String[] str= new String[1];
		str[0]="c:\\";
		
		dir.doCommand(str);
	}

}
