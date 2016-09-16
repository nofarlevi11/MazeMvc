package controller;

import model.Model;
import view.View;

// TODO: Auto-generated Javadoc
/**

 * <h1> The Class MyController. </h1>
 * <p>
 * This is a specific class that define the data and methods of our specific controller- for a Maze Problem
 * <p>
 * 
 * @author NofarLevi
 * @since September 2016
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

	/* 
	 * @see controller.CommonController#notifyMazeIsReady(java.lang.String)
	 */
	@Override
	public void notifyMazeIsReady(String name) {
		view.notifyMazeIsReady(name);
	}

	/*
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
