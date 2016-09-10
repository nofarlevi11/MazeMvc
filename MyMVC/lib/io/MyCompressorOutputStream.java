package io;

import java.io.IOException;
import java.io.OutputStream;

// TODO: Auto-generated Javadoc
/**
 * The Class MyCompressorOutputStream.
 */
public class MyCompressorOutputStream extends OutputStream{

	/** The OutObject where compressed thing will be saved*/
	private OutputStream out;
	
	/**
	 * Instantiates a new my compressor output stream.
	 *
	 * @param out the out
	 */
	public MyCompressorOutputStream(OutputStream out) {
		this.out = out;
	}
	
	/* (non-Javadoc)
	 * @see java.io.OutputStream#write(int)
	 */
	@Override
	public void write(int b) throws IOException {
		out.write(b);
	}
	
	/* (non-Javadoc)
	 * @see java.io.OutputStream#write(byte[])
	 */
	@Override
	public void write(byte[] arr) throws IOException {
		byte currByte = arr[0];
		int count = 1;
		
		for (int i = 1;i<arr.length;i++){
			if (arr[i] != currByte){
				while (count >= 255){
					out.write(255);
					out.write(currByte);
					count -= 255;
				}
				out.write(count);
				out.write(currByte);
				currByte = arr[i];
				count = 1;
			}
			else {
				count ++;
			}
	}
		out.write(count);
		out.write(currByte);
	}

}
