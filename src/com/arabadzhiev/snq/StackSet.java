package com.arabadzhiev.snq;

import java.util.EmptyStackException;

public class StackSet {
	
	private CountableStack[] buffer;
	private int index;
	private int maxHeight;
	
	public StackSet() {
		this(10);
	}
	
	public StackSet(int maxHeight) {
		this.buffer = new CountableStack[8];
		this.index = 0;
		this.maxHeight = maxHeight;
	}
	
	public void push(Integer value) {
		checkForResize();
		
		if(buffer[index] == null) {
			buffer[index] = new CountableStack();
		}
		
		if(buffer[index].getCount() == maxHeight) {
			index++;
			if(buffer[index] == null) {
				buffer[index] = new CountableStack();
			}
		}
		
		buffer[index].push(value);
		buffer[index].incrementCount();
	}
	
	public Integer pop() {
		if(buffer[index].isEmpty()) {
			index--;
			if(index < 0) {
				throw new EmptyStackException();
			}
		}
		
		System.out.println("From buffer: " + (index + 1));
		return buffer[index].pop();
	}
	
	public Integer peek() {
		if(buffer[index].isEmpty()) {
			index--;
			if(index < 0) {
				throw new EmptyStackException();
			}
		}
		
		return buffer[index].peek();
	}
	
	public Integer popFrom(int i) {
		return buffer[i].pop();
	}
	
	public boolean isEmpty() {
		return index - 1 < 0 && buffer[index].isEmpty();
	}
	
	
	private void checkForResize() {
		if(index + 1 == buffer.length) {
			CountableStack[] tmp =  new CountableStack[buffer.length * 2];
			for(int i = 0; i < buffer.length; i++) {
				tmp[i] = buffer[i];
			}
			buffer = tmp;
		}
	}

}
