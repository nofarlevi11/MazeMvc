package algorithms.search;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * This abstract class define the common features of the problems(/games) which can be solved by search algorithm
 * <p>.
 *
 * @author NofarLevi
 * @param <T> the generic type of the State
 */
public abstract class CommonSearcher<T> implements Seracher<T>{
	
	/** The evaluated nodes. */
	protected int evaluatedNodes;
	
	/* (non-Javadoc)
	 * @see algorithms.search.Seracher#getNumberOfNodesEvaluated()
	 */
	@Override
	public int getNumberOfNodesEvaluated() {
		return evaluatedNodes;
	}
	

	/**
	 * This method used to save the solution of the problem, into a list, after solving the problem
	 * 
	 * @param goalState is the last and finite step, and this function will find the steps of the solution
	 * by saving to a list, every CAMEFROM state, till the last one - the Start State
	 * 
	 * @param goalState the goal state
	 * @return the solution
	 */
	protected Solution<T> backTrace(State<T> goalState) {

			Solution<T> sol = new Solution<T>();
			
			State<T> currState = goalState;
			List<State<T>> states = sol.getStates();
			while (currState!=null){
				states.add(0, currState);
				currState = currState.getCameFrom();
			}
			
			sol.setSolutionCost(goalState.getCost());
			
			return sol;
	}
}

