package algorithms.mazeGenerators;

// TODO: Auto-generated Javadoc
/**
 * Position:
 * This class used to define a state for 3D Maze.
 * every Data Member is a dimension of the maze
 * 
 * @author NofarLevi
 *@since August 2016
 */
public class Position {

	/** The x. */
	public int x;
	
	/** The y. */
	public int y;
	
	/** The z. */
	public int z;
	
	/**
	 * Instantiates a new position.
	 *
	 * @param z the z
	 * @param y the y
	 * @param x the x
	 */
	public Position (int z, int y, int x){
		this.z=z;
		this.y=y;
		this.x=x;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{"+ x + "," + y + "," + z + "}";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Position pos = (Position)obj;
		return (this.x==pos.x && this.y==pos.y && this.z == pos.z);
	}
	
	/**
	 * Change by direction.
	 *
	 * @param d the Direction
	 */
	public void changeByDirection(Directions d){
		switch (d) {//Right, Left, Forward, Backward, Up ,Down
		case Left:
			this.x=this.x-1;
			break;
		case Right:
			this.x=this.x+1;
			break;
		case Forward:
			this.y=this.y+1;
			break;
		case Backward:
			this.y=this.y-1;
			break;
		case Up:
			this.z=this.z+1;
			break;
		case Down:
			this.z=this.z-1;
			break;
		default:
			//throw error
			break;
		}
	}
}

