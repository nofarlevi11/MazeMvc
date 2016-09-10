/*
 * 
 */
package algorithm.demo;

import java.util.ArrayList;
import java.util.List;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Searchable;
import algorithms.search.State;

// TODO: Auto-generated Javadoc
/**
 * The Class MazeAdapter.
 */
public class MazeAdapter implements Searchable<Position> {

	/** The maze 3 d. */
	protected Maze3d maze3d = null;
	
	/** The start state. */
	State<Position> startState = null;
	
	/** The goal state. */
	State<Position> goalState = null;
	
	/**
	 * Instantiates a new maze adapter.
	 *
	 * @param maze the maze
	 */
	public MazeAdapter(Maze3d maze) {
		this.maze3d = maze;
		this.startState = adaptPositionToState(maze.getStartPosition());
		this.goalState = adaptPositionToState(maze.getGoalPosition());
	}
	
	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getStartState()
	 */
	@Override
	public State<Position> getStartState() {
		//Position startPos = maze3d.getStartPosition();
		//return adaptPositionToState(startPos);
		return startState;
	}

	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getGoalState()
	 */
	@Override
	public State<Position> getGoalState() {
		return goalState;
	}
	

	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getAllPossibleStates(algorithms.search.State)
	 */
	@Override
	public ArrayList<State<Position>> getAllPossibleStates(State<Position> s) {
		
		List<Position> list = maze3d.getPossibleMoves(s.getValue());
		ArrayList<State<Position>> possibleStates = new ArrayList<State<Position>>();
		for (Position p : list){
			State<Position> newState = adaptPositionToState(p);
			newState.setCameFrom(s);
			possibleStates.add(newState);
		}

		return possibleStates;
	}

	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getMoveCost(algorithms.search.State, algorithms.search.State)
	 */
	@Override
	public double getMoveCost(State<Position> currState, State<Position> neighbor) {
		// TODO Auto-generated method stub
		return currState.getCost() + 1;
	}

	/**
	 * Adapt position to state.
	 *
	 * @param p the Position which will be adapted to State
	 * @return the state
	 */
	protected State<Position> adaptPositionToState (Position p){
		State<Position> s = new State<Position>(p.toString());
		s.setCameFrom(null);
		s.setCost(1);
		s.setValue(p);
		
		return s;
	}
	
}
