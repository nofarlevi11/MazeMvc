package algorithms.mazeGenerators;

// TODO: Auto-generated Javadoc
/**
 * <h1> Simple Maze Generator </h1>
 * This class used to define Simple algorithm of 3d Maze generating, by operating the method GENERATE..
 * 
 * This class extends the abstract class MazeGeneratorBase, which define common features of Maze Generator.
 * 
 * @author NofarLevi
 * @since August 2016
 */
public class SimpleMaze3dGenerator extends Maze3dGeneratorBase {

	/** The Constant WALL_RATIO. */
	private static final float WALL_RATIO = 0.5F;

	
	
	/**
	 * This method used to generate the 3D Maze, by the Simple Algorithm.
	 * It get the dimensions of the maze, and generate it by choosing randomly Position and put a wall into them (wall=1)
	 * and then, after choosing randomly a Start and Goal Position, it breaks some walls to create a track
	 * 
	 * @param floors, rows, cols (columns) - are the Dimensions of the maze (x, y, z)
	 * @return Maze3D which was generated.
	 */
	@Override
	public Maze3d generate(int floors, int rows, int cols) {

		this.maze3d = new Maze3d(floors, rows, cols);

		// go through random cells and make them occupied
		for(int i = 0 ; i < (int)(WALL_RATIO*floors*rows*cols) ; i++){
			int fl = rand.nextInt(floors);
			int ro = rand.nextInt(rows);
			int co = rand.nextInt(cols);
			Position pos = new Position(fl, ro, co);
			this.maze3d.setWall(pos);
		}
		
		//RANDOMING a start position
		Position startPos = chooseRandomPosition();
		this.maze3d.setFreeByPosition(startPos);
		this.maze3d.setStartPosition(startPos);
		
		//RANDOMING a goal position
		Position goalPos;
		do {
			goalPos = chooseRandomPosition();}
		while (goalPos.equals(startPos));
		this.maze3d.setGoalPosition(goalPos);
		this.maze3d.setFreeByPosition(goalPos);
				
		this.maze3d.createTrack(startPos, goalPos);
		
		System.out.println("Simple Maze Generation:");
		System.out.println(this.maze3d);
		return this.maze3d;
	}
}
