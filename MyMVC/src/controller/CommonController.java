package controller;

import model.Model;
import view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class CommonController.
 */
public abstract class CommonController implements Controller {

	/** The view. */
	protected View view;
	
	/** The model. */
	protected Model model;
	
	/** The command manager. */
	protected CommandManager commandManager;
	
	/**
	 * Instantiates a new common controller.
	 *
	 * @param view the view
	 * @param model the model
	 */
	public CommonController(View view, Model model) {
		this.view = view;
		this.model = model;
		
		commandManager = new CommandManager(model, view);
		view.setCommands(commandManager.getCommandsMap());
	}
	
	/* 
	 * @see controller.Controller#notifyMazeIsReady(java.lang.String)
	 */
	@Override
	public abstract void notifyMazeIsReady(String name);
}
