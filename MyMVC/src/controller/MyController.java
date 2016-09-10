package controller;

import model.Model;
import view.View;

public class MyController implements Controller {

	private View view;
	private Model model;
	private CommandManager commandManager;
	
	public MyController(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	
	@Override
	public void notifyMazeIsReady(String name) {
		view.notifyMazeIsReady(name);

	}

}
