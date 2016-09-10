package algorithms.search;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * This interface define the common functions of the problems(/games) which can be solved by search algorithm
 * Every problem has a Start State and Goal State, and by the algorithm,
 * the player will get, by finite number of steps, from the Start to the Goal
 * <p>.
 *
 * @author NofarLevi
 * @param <T> the generic type of the State
 */
public interface Searchable<T> {

	/**
	 * Gets the start state.
	 *
	 * @return the start state
	 */
	public State<T> getStartState();
	
	/**
	 * Gets the goal state.
	 *
	 * @return the goal state
	 */
	public State<T> getGoalState();
	
	/**
	 * Gets all of the possible states.
	 *
	 * @param s the State we want to check the possible states near to
	 * @return the list of the possible states (moves)
	 */
	public ArrayList<State<T>> getAllPossibleStates (State<T> s);
	
	/**
	 * Gets the move cost.
	 *
	 * @param currState the current state
	 * @param neighbor the neighbor
	 * @return the move cost
	 */
	public double getMoveCost(State<T>currState, State<T> neighbor);
}