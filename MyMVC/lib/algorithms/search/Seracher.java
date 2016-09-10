package algorithms.search;

// TODO: Auto-generated Javadoc
/**
 * The Interface Seracher.
 *
 * @param <T> the generic type of State
 */
public interface Seracher<T> {
	
	/**
	 * Gets the number of nodes evaluated.
	 *
	 * @return the number of nodes evaluated
	 */

	public int getNumberOfNodesEvaluated();
	
	/**
	 * Search.
	 *
	 * @param s the searchable problem
	 * @return the solution
	 */
	public Solution<T> search(Searchable<T> s);
	
}
