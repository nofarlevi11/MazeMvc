package algorithms.search;

import java.util.List;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * This class is defining the features of a Solution for a problem which can be solved by search algorithm.
 *
 * @author NofarLevi
 * @param <T> is a parameter which has to be injection specific according to the kind of State of our problem
 * @since August 2016
 */
public class Solution<T> {
	
	/** The states. */
	private List<State<T>> states = new ArrayList<State<T>>();
	
	/** The solution cost. */
	private double solutionCost;
	
	/**
	 * Gets the states.
	 *
	 * @return the states
	 */
	public List<State<T>> getStates(){
		return states;
	}
	
	/**
	 * Sets the state.
	 *
	 * @param states the new state
	 */
	public void setState(List<State<T>> states) {
		this.states = states;
	}
	
	/**
	 * Sets the solution cost.
	 *
	 * @param cost - the new solution cost which will be set
	 */
	public void setSolutionCost(double cost){
		this.solutionCost = cost;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (State<T> s : states) {
			sb.append(s.toString()).append(", ");
		}
		sb.append("\n");
		sb.append("Cost: " + this.solutionCost);
		
	return sb.toString();
	}
}
