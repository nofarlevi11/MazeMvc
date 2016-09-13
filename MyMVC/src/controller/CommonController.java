package controller;

import model.Model;
import view.View;

public abstract class CommonController implements Controller {

	protected View view;
	protected Model model;
	protected CommandManager commandManager;
	
	public CommonController(View view, Model model) {
		this.view = view;
		this.model = model;
		
		commandManager = new CommandManager(model, view);
		view.setCommands(commandManager.getCommandsMap());
	}
	@Override
	public abstract void notifyMazeIsReady(String name);
}
