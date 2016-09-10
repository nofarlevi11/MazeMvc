package algorithms.mazeGenerators;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * this Class used to define The Maze3d
 * has data members which represent the dimensions of the maze, the maze inself, and Stare+goal Position
 * also it has methods according to needs - "set Free / Wall", "get possible moves" and more.
 *
 * @author NofarLevi
 * @since August 2016
 */
public class Maze3d {

	/** The maze. */
	private int [][][] maze;
	
	/** The floors. */
	private int floors;
	
	/** The rows. */
	private int rows;
	
	/** The cols. */
	private int cols;
	
	/** The start position. */
	private Position startPosition;
	
	/** The goal position. */
	private Position goalPosition;
	
	/**
	 * Instantiates a new maze 3 d.
	 *
	 * @param floors the floors
	 * @param rows the rows
	 * @param cols the cols
	 */
	public Maze3d (int floors, int rows, int cols){
		this.floors=floors;
		this.rows=rows;
		this.cols=cols;
		maze = new int [floors][rows][cols];
	}
	
	/** The Constant FREE. */
	public static final int FREE = 0;
	
	/** The Constant WALL. */
	public static final int WALL = 1;

	
	/**
	 * Sets the wall.
	 *
	 * @param pos the new wall
	 */
	public void setWall(Position pos) {
		maze[pos.z][pos.y][pos.x] = WALL;
	}
	
	/**
	 * Sets the free by position.
	 *
	 * @param pos the new free by position
	 */
	public void setFreeByPosition(Position pos) {
		maze[pos.z][pos.y][pos.x] = FREE;
	}
	
	/**
	 * Sets the free by int.
	 *
	 * @param z the z
	 * @param y the y
	 * @param x the x
	 */
	public void setFreeByInt (int z, int y, int x) {
		maze[z][y][x] = FREE;
	}
	
	/**
	 * Gets the value.
	 *
	 * @param z the z
	 * @param y the y
	 * @param x the x
	 * @return the value
	 */
	public int getValue(int z, int y, int x) {
		return maze[z][y][x];
	}
	
	
	
	/**
	 * Gets the start position.
	 *
	 * @return the start position
	 */
	public Position getStartPosition() {
		return startPosition;
	}

	/**
	 * Sets the start position.
	 *
	 * @param startPosition the new start position
	 */
	public void setStartPosition(Position startPosition) {
		this.startPosition = startPosition;
	}

	/**
	 * Gets the goal position.
	 *
	 * @return the goal position
	 */
	public Position getGoalPosition() {
		return goalPosition;
	}

	/**
	 * Sets the goal position.
	 *
	 * @param goalPosition the new goal position
	 */
	public void setGoalPosition(Position goalPosition) {
		this.goalPosition = goalPosition;
	}

	/**
	 * Gets the floors.
	 *
	 * @return the floors
	 */
	public int getFloors() {
		return floors;
	}

	/**
	 * Gets the rows.
	 *
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * Gets the cols.
	 *
	 * @return the cols
	 */
	public int getCols() {
		return cols;
	}

	/**
	 * Gets the maze.
	 *
	 * @return the maze
	 */
	public int[][][] getMaze() {
		return maze;
	}

	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int z = 0; z < floors; z++){
			for (int y = 0; y<rows;y++){
				for (int x = 0 ; x< cols ; x++){
					if (z==startPosition.z && y==startPosition.y && x==startPosition.x)
						sb.append("E ");
					else if (z==goalPosition.z && y==goalPosition.y && x==goalPosition.x)
						sb.append("X ");
					else
						sb.append(maze[z][y][x] + " ");
				}
				sb.append("\n");
			}
			sb.append("\n");
			
		}
		return sb.toString();
	}
	
	
	/**
	 * this method is a Auxiliary function, used in some algorithms of generation - 
	 * it sets wall in all of the cells of the maze.
	 * it will be used depending on the behavior of the algorithm, as needed
	 *
	 * @author NofarLevi
	 * @return nothing
	 * @since August 2016
	 */
	public void initWalls (){
		for (int z = 0; z < floors; z++)
			for (int y = 0; y<rows;y++)
				for (int x = 0 ; x< cols ; x++)
					setWall(new Position (z, y, x));
	}
	
	
	
	/**
	 * this method is a Auxiliary function, used in some algorithms of search - 
	 * it checks for the possible moves from given position.
	 *
	 * @author NofarLevi
	 * @param p - the given position
	 * @return the List of the Possible moves
	 * @since August 2016
	 */
	public ArrayList<Position> getPossibleMoves(Position p){
		
		ArrayList<Position> possibleMoves = new ArrayList<Position>();
		
		if (p.x+1 < cols && maze[p.z][p.y][p.x+1] == FREE)
			possibleMoves.add(new Position(p.z,p.y,p.x+1));
		if (p.x-1 >= 0 && maze[p.z][p.y][p.x-1] == FREE)
			possibleMoves.add(new Position(p.z,p.y,p.x-1));
		if (p.y+1 < rows && maze[p.z][p.y+1][p.x] == FREE)
			possibleMoves.add(new Position(p.z,p.y+1,p.x));
		if (p.y-1 >= 0 && maze[p.z][p.y-1][p.x] == FREE)
			possibleMoves.add(new Position(p.z,p.y-1,p.x));
		if (p.z+1 < floors && maze[p.z+1][p.y][p.x] == FREE)
			possibleMoves.add(new Position(p.z+1,p.y,p.x));
		if (p.z-1 >= 0 && maze[p.z-1][p.y][p.x] == FREE)
			possibleMoves.add(new Position(p.z-1,p.y,p.x));
		
		return possibleMoves;
	}
	
	/**
	 * this method is a Auxiliary function, used in some algorithms of generation - 
	 * it creating a track between two given Positions.
	 * it will be used depending on the behavior of the algorithm, as needed
	 *
	 * @author NofarLevi
	 * @param start is the StartPosition - the beginning of the track
	 * @param goal is the DestinationPosition - the end og the track
	 * @return nothing
	 * @since August 2016
	 */
	public void createTrack (Position start, Position goal){
		int startZ = start.z;
		int startY = start.y;
		int startX = start.x;
		int goalZ = goal.z;
		int goalY = goal.y;
		int goalX = goal.x;
		// create track on the Z axis
		if (startZ > goalZ){
			for (; startZ > goalZ ; startZ--){
				maze[startZ][startY][startX] = Maze3d.FREE;
			}
		}
		if (startZ < goalZ){
			for (; startZ < goalZ ; startZ++){
				maze[startZ][startY][startX] = Maze3d.FREE;
			}
		}
		// create track on the Y axis
		if (startY > goalY){
			for (; startY > goalY ; startY--){
				maze[startZ][startY][startX] = Maze3d.FREE;
			}
		}
		if (startY < goalY){
			for (; startY < goalY ; startY++){
				maze[startZ][startY][startX] = Maze3d.FREE;
			}
		}
		// create track on the x axis
		if (startX > goalX){
			for (; startX > goalX ; startX--){
				maze[startZ][startY][startX] = Maze3d.FREE;
			}
		}
		if (startX < goalX){
			for (; startX < goalX ; startX++){
				maze[startZ][startY][startX] = Maze3d.FREE;
			}
		}
	}
	
	
	/**
	 * this 3 methods is used to create 2d maze, by using two of the three dimensions of the 3d maze.
	 *
	 * @author NofarLevi
	 * @param x or y or z - the dimension of the 3dMaze which the 2dMaze will be crossed from
	 * @return 2d array of integers (the 2dMaze)
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 * @since August 2016
	 */
	
	/**
	 * Gets the cross section by X.
	 *
	 * @param x the x
	 * @return the cross section by x
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public int [][] getCrossSectionByX(int x) throws IndexOutOfBoundsException {
		if (x >=0 && x<=getCols()){
			int [][] maze2d=new int [getRows()][getFloors()];
			for (int y = 0; y<getRows();y++)
				for (int z = 0;z<getFloors();z++)
					maze2d[y][z] = maze[x][y][z];
		
			return maze2d;
			}
		throw new IndexOutOfBoundsException();
	}
	
	/**
	 * Gets the cross section by Y.
	 *
	 * @param y the y
	 * @return the cross section by Y
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public int [][] getCrossSectionByY(int y) throws IndexOutOfBoundsException {
		if (y >=0 && y<=getRows()){

			int [][] maze2d = new int [getCols()][getFloors()];
		
			for (int x = 0; x<getCols();x++)
				for (int z = 0;z<getFloors();z++)
					maze2d[x][z] = maze[x][y][z];
		
			return maze2d;
		}
		throw new IndexOutOfBoundsException();

	}
	
	public byte [] toByteArray() {
		ArrayList<Byte> arr = new ArrayList<Byte>();
		//saving the dimensions
		arr.add((byte)floors);
		arr.add((byte) rows);
		arr.add((byte)cols);

		//saving the position of the start & goal point
		arr.add((byte) startPosition.z);
		arr.add((byte) startPosition.y);
		arr.add((byte) startPosition.x);

		arr.add((byte) goalPosition.z);
		arr.add((byte) goalPosition.y);
		arr.add((byte) goalPosition.x);
		
		//saving the maze itself
		for (int z = 0; z < floors; z++)
			for (int y = 0; y<rows;y++)
				for (int x = 0 ; x< cols ; x++) {
					arr.add((byte)maze[z][y][x]);
				}
			
		//converting the List to an Array of bytes
		byte[]bytes = new byte[arr.size()];
		for (int i = 0 ; i<bytes.length; i++){
			bytes[i] = (byte)arr.get(i);
		}
		
		return bytes;
	}
	
	
	public Maze3d (byte[]arr) {
		int k = 0;
		this.floors = arr[k++];
		this.rows = arr[k++];
		this.cols = arr[k++];

		maze = new int [floors][rows][cols];
		
		Position startPos = new Position (arr[k++], arr[k++], arr[k++]);
		this.setStartPosition(startPos);
		
		Position goalPos = new Position (arr[k++], arr[k++], arr[k++]);
		this.setGoalPosition(goalPos);
		
		for (int z = 0; z < floors; z++)
			for (int y = 0; y<rows;y++)
				for (int x = 0 ; x< cols ; x++)
					maze[z][y][x] = arr[k++];
	}
	
	
	/**
	 * Gets the cross section by Z.
	 *
	 * @param z the z
	 * @return the cross section by Z
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	public int [][] getCrossSectionByZ(int z) throws IndexOutOfBoundsException {
		if (z >=0 && z<=getFloors()){

			int [][] maze2d = new int [getCols()][getRows()];
		
			for (int x = 0; x<getCols();x++)
				for (int y = 0;y<getRows();y++)
					maze2d[x][y] = maze[x][y][z];
		
			return maze2d;
		}
		throw new IndexOutOfBoundsException();
	}
	
	public boolean equals(Maze3d anotherMaze) {
		if (this.floors!= anotherMaze.getFloors() || this.rows != anotherMaze.getRows() || this.cols != anotherMaze.getCols())
			return false;
		else if (!this.startPosition.equals(anotherMaze.getStartPosition()) || !this.goalPosition.equals(anotherMaze.getGoalPosition())){
			return false;
		}
		for (int z = 0 ; z<floors;z++){
			for (int y = 0 ; y< rows ; y++){
				for (int x = 0 ; x < cols ; x++){
					if (this.maze[z][y][x] != anotherMaze.getValue(z, y, x)){
					return false;
					}
				}
			}
		}
		return true;

			
				
	}
}

	
