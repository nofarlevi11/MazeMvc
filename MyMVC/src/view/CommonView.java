package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class CommonView.
 */
public abstract class CommonView implements View {

	/** The in. */
	protected BufferedReader in;
	
	/** The out. */
	protected PrintWriter out;
	
	/** The cli. */
	protected CLI cli;
	
	/** The controller. */
	protected Controller controller;
	
	/**
	 * Instantiates a new common view.
	 *
	 * @param in the in
	 * @param out the out
	 */
	public CommonView (BufferedReader in, PrintWriter out) {
		this.in = in;
		this.out=out;
		cli = new CLI (in, out);
	};

}
