/*
 * 
 */
package algorithm.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.mazeGenerators.SimpleMaze3dGenerator;
import algorithms.search.BFS;
import algorithms.search.DFS;
import algorithms.search.Solution;
import io.MyCompressorOutputStream;

// TODO: Auto-generated Javadoc
/**
 * The Class Demo.
 */
public class Demo {


	
//	OutputStream out=new MyCompressorOutputStream(
//			new FileOutputStream("1.maz"));
//			out.write(maze.toByteArray());
//			out.flush();
//			out.close();
//			InputStream in=new MyDecompressorInputStream(
//			new FileInputStream("1.maz"));
//			byte b[]=new byte[maze.toByteArray().length];
//			in.read(b);
//			in.close();
//			Maze3d loaded=new Maze3d(b);
//			System.out.println(loaded.equals(maze));

	
	/**
	 * Run.
	 */
	public void run() {
		
		SimpleMaze3dGenerator gtg = new SimpleMaze3dGenerator();
		Maze3d myMaze = gtg.generate(5, 5, 5); //generating a maze with the GrowingTreeGenerator
		System.out.println(myMaze); //printing the maze
		
		MazeAdapter mazeAdapter = new MazeAdapter(myMaze); //sending the maze which was generated, to the Maze Adapter
		
		BFS<Position> bfsAlg = new BFS<Position>(); //creating an object of BFS
		Solution<Position> sol = bfsAlg.search(mazeAdapter); //operating the Search function, to solve the maze, by the BFS algo
		System.out.println("BFS Solution:");
		System.out.println(sol); //printing the solution
		
		System.out.println("Evaluated Nodes: " + bfsAlg.getNumberOfNodesEvaluated());
		
		System.out.println("");
		
		DFS<Position> dfsAlg = new DFS<Position>(); //creating an object of BFS
		Solution<Position> sol2 = dfsAlg.search(mazeAdapter);  //operating the Search function, to solve the maze, by the DFS algo
		System.out.println("DFS Solution:");
		System.out.println(sol2);  //printing the solution
		System.out.println("Evaluated Nodes: " + dfsAlg.getNumberOfNodesEvaluated());

	}
}
