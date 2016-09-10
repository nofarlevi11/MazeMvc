package algorithms.mazeGenerators;

import java.util.Random;

import algorithms.mazeGenerators.Maze3d;

// TODO: Auto-generated Javadoc
/**
 * This abstract class used to define all the common feature of MazeGenerator algorithms.
 * 
 * @author NofarLevi
 * @since August 2016
 */
public abstract class Maze3dGeneratorBase implements Maze3dGenerator{

	/** The rand. */
	protected Random rand = new Random();
	
	/** The maze 3 d. */
	protected Maze3d maze3d;
	
	/**
	 * Gets the maze.
	 *
	 * @return the maze
	 */
	public Maze3d getMaze() { //return the maze
		return maze3d;
	}
	
	/**
	 * <h1> Measure Algorithm Time </h1>
	 * This method used to measure the time it takes to generate a 3d maze
	 * by checking the current time before and after the generation, and find the difference between them
	 * 
	 * <p>.
	 *
	 * @param floors the floors
	 * @param rows the rows
	 * @param cols the cols
	 * @return String - the difference between the start and end generation.
	 */
	@Override
	public String measureAlgorithmTime(int floors, int rows, int cols) {
		long startTime = System.currentTimeMillis();
		this.generate(floors, rows, cols);
		long endTime = System.currentTimeMillis();
		System.out.println("Time Generation:");
		return String.valueOf(endTime - startTime);		
	}
	
	/**
	 * <h1> Choose Random Position </h1>
	 * This method used to generate position randomly.
	 * it used to choose randomly start or goal position, when using the generation algorithms.
	 * this method choose a random integer within the dimension of the maze,
	 * and makes sure it is an even number
	 * 
	 * <p>
	 * @return Position - the Position which was now generated
	 */
	protected Position chooseRandomPosition() {
		int x = rand.nextInt(maze3d.getCols());
		while (x % 2 == 1)
			x = rand.nextInt(maze3d.getCols());
		
		int y = rand.nextInt(maze3d.getRows());
		while (y % 2 == 1)
			y = rand.nextInt(maze3d.getRows());	
		
		int z = rand.nextInt(maze3d.getFloors());
		while (z % 2 == 1)
		z = rand.nextInt(maze3d.getFloors());	
		
		return new Position(z, y, x);
	}
	
	/**
	 * <h1> Break Wall </h1>
	 * This method used to break wall (Put 0) between 2 given Positions.
	 * it checks what direction is the neighbor from, and breaking the wall between them ("Paving the way between points")
	 * 
	 * <p>
	 * @param pos - source position
	 * @param neighbor - destination position
	 * @return nothing
	 */
	protected void breakWall(Position pos, Position neighbor){
		
		//we must check which what direction is it neighbor from
		if (neighbor.x == pos.x + 2) {
			maze3d.setFreeByInt(pos.z, pos.y, pos.x+1);
			maze3d.setFreeByInt(pos.z, pos.y, pos.x+2);
		}
		else if (neighbor.x == pos.x - 2) {
			maze3d.setFreeByInt(pos.z, pos.y, pos.x-1);
			maze3d.setFreeByInt(pos.z, pos.y, pos.x-2);
		}
		else if (neighbor.y == pos.y + 2) {
			maze3d.setFreeByInt(pos.z, pos.y + 1, pos.x);
			maze3d.setFreeByInt(pos.z, pos.y + 2, pos.x);
		}
		else if (neighbor.y == pos.y - 2) {
			maze3d.setFreeByInt(pos.z, pos.y - 1, pos.x);
			maze3d.setFreeByInt(pos.z, pos.y - 2, pos.x);
		}
		else if (neighbor.z == pos.z + 2) {
			maze3d.setFreeByInt(pos.z+1, pos.y, pos.x);
			maze3d.setFreeByInt(pos.z+2, pos.y, pos.x);
		}
		else if (neighbor.z == pos.z - 2) {
			maze3d.setFreeByInt(pos.z-1, pos.y, pos.x);
			maze3d.setFreeByInt(pos.z-2, pos.y, pos.x);
		}
	}
	

	/**
	 * this function used to define the way of making generation of a 3d maze.
	 * it implemented in the classes at the next stage of the extension tree
	 * <p>
	 * @param floors, rows, cols (columns) - are the Dimensions of the maze (x, y, z)
	 * @return Maze3D which was generated.
	 */
	 
	public abstract Maze3d generate (int floor, int rows, int cols);
}
