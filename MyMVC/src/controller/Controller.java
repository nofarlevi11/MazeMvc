package controller;

// TODO: Auto-generated Javadoc
/**
 * <h1> The Interface Controller. </h1>
 * <p>
 * This interface will be implements by specific Controller - <p>
 * classes that are the CONTROLLER in a MVC (model, view, controller) pattern
 * <p>
 * 
 * @author NofarLevi
 * @since September 2016
 */

public interface Controller {
	
	/**
	 * Notify maze is ready.
	 *
	 * @param name the name of the maze
	 */
	void notifyMazeIsReady (String name);
	
	/**
	 * Notify maze was solved.
	 *
	 * @param name the name of the maze
	 */
	void notifyMazeWasSolved(String name);
	
	/**
	 * Notify bad input.
	 */
	void notifyBadInput();
}
