package io;

import java.io.IOException;
import java.io.InputStream;

// TODO: Auto-generated Javadoc
/**
 * The Class MyDecompressorInputStream.
 */
public class MyDecompressorInputStream extends InputStream{

	/** The in. */
	private InputStream in;
	
	/**
	 * Instantiates a new my decompressor input stream.
	 *
	 * @param in the in
	 */
	public MyDecompressorInputStream(InputStream in){
		this.in=in;
	}
	
	/* (non-Javadoc)
	 * @see java.io.InputStream#read(byte[])
	 */
	@Override
	public int read(byte[] arr) throws IOException {
		int i = 0;
		int fileSize = in.available();
		
		for (int k = 0 ; i<fileSize; i+=2) {
			if (arr.length <= i)
				break;
			byte count = (byte) in.read();
			byte b = (byte) in.read();
			
			for (int j = 0 ; j < count ; j++) {
				if(arr.length <= i){
					break;
				}
				arr[k++] = b;
			}
		}
		return arr.length;
	}

	/* 
	 * @see java.io.InputStream#read()
	 */
	@Override
	public int read() throws IOException {
		return in.read();
	}
}
