package com.arabadzhiev.utility;


public class StringBuilder {
	
	private char[] buffer;
	private int size;
	
	public StringBuilder() {
		buffer = new char[16];
		size = 0;
	}
	
	public StringBuilder(int initSize) {
		buffer = new char[initSize];
		size = 0;
	}
	
	public StringBuilder(String initString) {
		int initSize = initString.length() > 16 ? initString.length() : 16;
		buffer = new char[initSize];
		append(initString);
	}
	
	public void append(char c) {
		checkForUpdate();
		buffer[size] = c;
		size++;
	}
	
	public void append(String s) {
		for(char c : s.toCharArray()) {
			checkForUpdate();
			buffer[size] = c;
			size++;
		}
	}
	
	private void checkForUpdate() {
		if(size == buffer.length) {
			char[] newBuffer = new char[size * 2];
			for(int i = 0; i < size; i++) {
				newBuffer[i] = buffer[i];
				
			}
			buffer = newBuffer;
		}
	}
	
	public String toString() {
		return new String(buffer, 0, size);
	}
}
