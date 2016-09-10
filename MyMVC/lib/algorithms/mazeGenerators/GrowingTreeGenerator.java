package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * <h1> Growing Tree Generator </h1>
 * This class used to define Growing Tree algorithm of 3d Maze generating, by operating the method GENERATE..
 * 
 * This class extends the abstract class MazeGeneratorBase, which define common features of Maze Generator.
 * 
 * @author NofarLevi
 * @since August 2016
 */
public class GrowingTreeGenerator extends Maze3dGeneratorBase {
	

	/**
	 * This method used to generate the 3D Maze, by the GrowingTree Algorithm.
	 * It get the dimensions of the maze, and creating a maze with only walls into it,
	 * and then, for every position, starting with the Start Position that was choose randomly,
	 * the alg. checks for the unvisited neighbor and breaking the wall between them, according to the order.
	 * the alg. finish it mission, when the current Position have not another Unvisited neighbors, and all of the cells was visited.
	 * then it chooses randomly a Goal Position
	 *  
	 * @param floors, rows, cols (columns) - are the Dimensions of the maze (x, y, z)
	 * @return Maze3D which was generated.
	 */
@Override
	public Maze3d generate(int floors, int rows, int cols) {
		
		this.maze3d = new Maze3d(floors, rows, cols);
		this.maze3d.initWalls(); //initializing the maze
		
		//mat which is copy of our maze, but with boolean values, according to the cells visiting status
		boolean [][][] visited = new boolean [floors][rows][cols]; 
		List<Position> cells = new ArrayList<Position>();

		
		Position startPos = chooseRandomPosition(); //Choosing a random cell to start from. must be even. 
		maze3d.setFreeByPosition(startPos);
		maze3d.setStartPosition(startPos);
		cells.add(startPos); //adding the startPosition to the list of the cells

		visited[startPos.z][startPos.y][startPos.x] = true;
		
		while (!cells.isEmpty()) {

			Position pos = cells.get(cells.size()-1);
			List <Position> neighbors = getUnvisitedNeighbors(pos, visited);
			
			if (!neighbors.isEmpty()) { //if there are Unvisited neighbors...
				Position neighbor = neighbors.get(rand.nextInt(neighbors.size()));
				breakWall(pos, neighbor);
				cells.add(neighbor);
//				numOfVisitedCells++;
				visited[neighbor.z][neighbor.y][neighbor.x] = true; //updating the control Mat
			}
			else {
				cells.remove(pos);
			}
		}
	
		Position goalPos;
		do {
			goalPos = chooseRandomPosition();}
		while (goalPos.equals(startPos));
		this.maze3d.setGoalPosition(goalPos);
		this.maze3d.setFreeByPosition(goalPos);
		
		
//		System.out.println("Growing Tree Generation:");
//		System.out.println(maze3d);
		return maze3d;
		}
			


	/**
	 * This function is a Auxiliary function, used by the method Generate of the growing tree generator.
	 * it used to create a list of unvisited neighbors of one position.
	 * it makes it also by managing the Visited/Unvisited indicator..
	 *  
	 * @param pos is the Position which the function will check for unvisited neighbors of.
	 * @param visited is a matrix of boolean values, with the same dimensions like the generated maze,
	 * which indicate in every parallel cell whether it was visited (TRUE) or not (FALSE)
	 * 
	 * @return Array List of Position
	 */
	private ArrayList<Position> getUnvisitedNeighbors(Position pos, boolean[][][] visited){

		ArrayList<Position> neighbors = new ArrayList<Position>();
			if (pos.x - 2 >= 0 && 
				visited[pos.z][pos.y][pos.x -2] == false) {
			neighbors.add(new Position(pos.z, pos.y, pos.x-2));
		}
			if (pos.x + 2 < this.maze3d.getCols() && 
				visited[pos.z][pos.y][pos.x +2] == false) {
			neighbors.add(new Position(pos.z, pos.y, pos.x+2));
		}
		
		if (pos.y - 2 >=0 && 
				visited[pos.z][pos.y-2][pos.x] == false) {
			neighbors.add(new Position(pos.z, pos.y-2, pos.x));
		}
		
		if (pos.y + 2 < this.maze3d.getRows() && 
				visited[pos.z][pos.y+2][pos.x] == false) {
			neighbors.add(new Position(pos.z, pos.y+2, pos.x));
		}
		
		if (pos.z -2 >= 0 &&
				visited[pos.z-2][pos.y][pos.x] == false) {
			neighbors.add(new Position(pos.z-2, pos.y, pos.x));
		}
		
		if (pos.z + 2 < this.maze3d.getFloors() &&
				visited[pos.z+2][pos.y][pos.x] == false) {
			neighbors.add(new Position(pos.z+2, pos.y, pos.x));
		}
	
		return neighbors;
	}

}
