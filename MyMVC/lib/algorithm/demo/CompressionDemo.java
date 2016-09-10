package algorithm.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

public class CompressionDemo {

	public void run(){
		GrowingTreeGenerator myGr = new GrowingTreeGenerator();
		Maze3d maze = myGr.generate(5, 5, 5); //generate the maze
		OutputStream out = null;
		try {
			out = new MyCompressorOutputStream(new FileOutputStream("1.maz"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			out.write(maze.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			out.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InputStream in = null;
		try {
			in = new MyDecompressorInputStream(new FileInputStream("1.maz"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte b[] = new byte [maze.toByteArray().length];
		try {
			in.read(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Maze3d loaded = new Maze3d(b);
		System.out.println(loaded.equals(maze));

		
	}
}
