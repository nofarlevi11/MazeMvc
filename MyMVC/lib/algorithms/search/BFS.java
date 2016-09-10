package algorithms.search;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class BFS.
 *
 * @param <T> the generic type of the State
 * 
 * Answers for the questions in the mission document:

 *  1. the advantages of every Algorithm: <p>
 *	by using the BFS algorithm one can solve the maze at lower *cost*, but more evaluated nodes - (longer time)<p>
 *	by using the DFS algorithm one can solve the maze faster (less time), less "open neighbors", but higher cost <p>
 *   2. I choose to implement the BFS algorithm this way because this is the way I learned it from the lesson and the pseudo code<p>
 *	in conclusion - the DFS is faster but more expensive, and the BFS is cheaper but less fast <p>
 *   3. Answer for the mouse maze question: according to wikipedia, the meaning of Evaluated Nodes is - the cells which was visited and will not be visited again. <p>
 *	Therefore, the number of Evaluated Nodes of every Algorithm is:<p>
 *	BFS: 10<p>
 *	DFS: 6<p>
 */
public class BFS<T> extends CommonSearcher<T>{

	/** The open list. (Priority List) */
	private PriorityQueue<State<T>> openList = new PriorityQueue<State<T>>();
	
	/** The close list. */
	private Set<State<T>> closeList = new HashSet<State<T>>();
	
	/**
	 * <h1> BFS (Breadth-first search) algorithm </h1>
	 * DFS is an algorithm for searching tree data structure:
	 * It starts at the StartState, and explores the neighbor nodes (Possible Moves) first, before moving to the next level neighbors.
	 *
	 * @author NofarLevi
	 * @see https://en.wikipedia.org/wiki/Breadth-first_search
	 * @since August 2016
	 */
	public BFS() { 
		super(); 
 	} 

	/**
	 * This method used to operate the search action according to the BFS algorithm
	 * is happens by using two lists -
	 * Open List - which contain the possible neighbors of every stage, sorting by the priority,
	 * and Close list - which contains the current state of every stage.
	 * The Close List, finally, will contain the finite solution..
	 * 
	 * @param s is the SearchAble problem
	 * @return the Solution
	 * 
	 */
	@Override
	public Solution<T> search(Searchable<T> s) {

		
		State<T> startState = s.getStartState();
		startState.setCost(0);
		openList.add(startState);
		
		while (!openList.isEmpty()){
			State<T> currState=openList.poll();
			closeList.add(currState);
			this.evaluatedNodes++;
			State<T> goalState = s.getGoalState();
			
			if (currState.equals(goalState)) {
				return backTrace(currState);
			}	
			List<State<T>> neighbours = s.getAllPossibleStates(currState);
			for (State<T> neighbor : neighbours){
				if (!openList.contains(neighbor) && !closeList.contains(neighbor)) {
					neighbor.setCameFrom(currState);
					neighbor.setCost(s.getMoveCost(currState, neighbor));
					openList.add(neighbor);
					
				}
				else{
					double newPathCost = (currState.getCost() + s.getMoveCost(currState, neighbor));
					if (neighbor.getCost() > newPathCost){
						neighbor.setCost(newPathCost);
						neighbor.setCameFrom(currState);
					
						if(!openList.contains(neighbor)){
							openList.add(neighbor);
						}
						else{ //for updating the sorting by the priority...
							openList.remove(neighbor);
							openList.add(neighbor);
						}
					}
				}
			}
		}
		
	return null;
	}
}
