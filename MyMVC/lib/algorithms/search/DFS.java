package algorithms.search;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * <h1> DFS (Depth-first search) algorithm </h1>
 * DFS is an algorithm for searching tree data structure:
 * One start at the StartState, and explores as far as possible along each branch (Possible Moves), before backTracking.
 *
 * @author NofarLevi
 * @param <T> define the kind of State for the problem we are going to solve
 *  
 * @see https://en.wikipedia.org/wiki/Depth-first_search#Properties
 * @since August 2016
 */
public class DFS<T> extends CommonSearcher<T> {

	/** The start state. */
	private State<T> startState;
	
	/** The goal state. */
	private State<T> goalState;
	
	/** The list og the visited cells. */
	List <State<T>> visited = new ArrayList<State<T>>();
	
	
	/**
	 * This method used to operate the search action according to the DFS algorithm
	 * is happens by operate another method - the algDFS - a recursive method which execute the search by the DFS alg.
	 * This method also operates the BackTrace function, after solving the problem..
	 * 
	 * @author NofarLevi
	 * @param s is the SearchAble problem
	 * @return Solution
	 * 
	 */
	@Override
	public Solution<T> search(Searchable<T> s) {


		startState = s.getStartState();
		goalState = s.getGoalState();
		visited.add(startState);
		algDFS(startState, s);
		
		Solution<T> solution = backTrace(goalState);
		solution.setSolutionCost(goalState.getCost());
		return solution;
	}
	

	private void algDFS (State<T> state, Searchable<T> s){
		
		/**
		 * This method is defining the Recursive Operation of the DFS itself.
		 * From the Start state, the algorithm check for possible states, and get deeply in every optional state,
		 * after that it goes beck and check deeply for the next state.
		 * 
		 * @param state is the start state
		 * @param s is the problem
		 * @return nothing
		 * @author NofarLevi
		 */
		if (state.equals(goalState)){
			//state.setCost(state.getCameFrom().getCost() + s.getMoveCost(state.getCameFrom(), state));
			s.getGoalState().setCameFrom(state.getCameFrom());
			goalState.setCost(state.getCost());
			return;
		}
		List <State<T>> possibleMoves = s.getAllPossibleStates(state);
		
		for (State<T> st : possibleMoves){
			if (!visited.contains(st)){
			st.setCameFrom(state);
			st.setCost(s.getMoveCost(state, st));
			visited.add(st);
			this.evaluatedNodes++;
			algDFS (st, s);
			}
		}
		return;
	}

}