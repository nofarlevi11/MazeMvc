package controller;

// TODO: Auto-generated Javadoc
/**
 * The Interface Controller.
 */
public interface Controller {
	
	/**
	 * Notify maze is ready.
	 *
	 * @param name the name
	 */
	void notifyMazeIsReady (String name);
	
	/**
	 * Notify maze was solved.
	 *
	 * @param name the name
	 */
	void notifyMazeWasSolved(String name);
	
	void notifyBadInput();
}
