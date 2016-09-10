package algorithms.search;
// TODO: Auto-generated Javadoc

/**
 * State <T>:
 * This class used to define a state for Every Searchable Problem.
 * every Data Member is a dimension of the maze
 *
 * @author NofarLevi
 * @param <T> the generic type of the State
 * @since August 2016
 */
public class State<T> implements Comparable<State<T>> {
	
	/** The came from. */
	private State<T> cameFrom;
	
	/** The cost. */
	private double cost;
	
	/** The value. */
	private T value;
	
	/** The key. */
	private String key;
	
	/**
	 * Instantiates a new state.
	 *
	 * @param key the key
	 */
	public State (String key){
		this.key = key;
	}
	

	@Override
	public String toString() {
		return value.toString();
	}

	/**
	 * Gets the came from.
	 *
	 * @return the came from
	 */
	public State<T> getCameFrom() {
		return cameFrom;
	}

	/**
	 * Sets the came from.
	 *
	 * @param cameFrom the new came from
	 */
	public void setCameFrom(State<T> cameFrom) {
		this.cameFrom = cameFrom;
	}

	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * Sets the cost.
	 *
	 * @param cost the new cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public T getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key the new key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Equals.
	 *
	 * @param s the object we want to check if equals to the State
	 * 
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		@SuppressWarnings("unchecked")
		State<T> s = (State<T>) obj;
		return s.value.equals(this.value);
	}

	/**
	 * Equals.
	 *
	 * @param s the state we want to check if equals
	 * 
	 * @return true, if successful
	 */
	public boolean equals(State<T> s) {
		return s.value.equals(this.value);
	}
	
	
	
	@Override
	public int compareTo(State<T> s) {
		return (int)(this.getCost() - s.getCost());
	}
	
	
}
