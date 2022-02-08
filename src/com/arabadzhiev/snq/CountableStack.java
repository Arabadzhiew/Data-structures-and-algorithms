package com.arabadzhiev.snq;

import com.arabadzhiev.collections.Stack;

public class CountableStack extends Stack<Integer>{
	
	private int count;
	
	public CountableStack() {
		count = 0;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public void incrementCount() {
		count++;
	}
	
	public void decrementCount() {
		count--;
	}
}
