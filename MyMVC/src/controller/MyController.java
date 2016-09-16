package controller;

import model.Model;
import view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class MyController.
 */
public class MyController extends CommonController {

	/**
	 * Instantiates a new my controller.
	 *
	 * @param view the view
	 * @param model the model
	 */
	public MyController(View view, Model model) {
		super(view, model);
	}

	/* (non-Javadoc)
	 * @see controller.CommonController#notifyMazeIsReady(java.lang.String)
	 */
	@Override
	public void notifyMazeIsReady(String name) {
		view.notifyMazeIsReady(name);
	}

	/* (non-Javadoc)
	 * @see controller.Controller#notifyMazeWasSolved(java.lang.String)
	 */
	@Override
	public void notifyMazeWasSolved(String name) {
		view.notifyMazeWasSolved(name);
	}

	@Override
	public void notifyBadInput() {
		view.notifyBadInput();
	}


	
	
}
