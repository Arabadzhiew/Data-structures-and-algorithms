package com.arabadzhiev.collections;

public class Listy {
	private int[] buffer;
	
	public Listy(int[] buffer) {
		this.buffer = buffer;
	}
	
	public int elementAt(int i) {
		if(i < 0 || i >= buffer.length) {
			return - 1;
		}
		
		return buffer[i];
	}
}
