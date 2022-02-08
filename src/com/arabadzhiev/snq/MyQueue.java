package com.arabadzhiev.snq;

import java.util.NoSuchElementException;

import com.arabadzhiev.collections.Stack;

public class MyQueue<T> {
	Stack<T> primary = new Stack<>();
	Stack<T> secondary = new Stack<>();
	
	public void put(T value) {
		primary.push(value);
	}
	
	public T peek() {
		if(secondary.isEmpty() || !primary.isEmpty()) {
			reverse();
		}
		if(secondary.isEmpty()) {
			throw new NoSuchElementException();
		}
		T value = secondary.peek();
		return value;
	}
	
	public T remove() {
		if(secondary.isEmpty() || !primary.isEmpty()) {
			reverse();
		}
		if(secondary.isEmpty()) {
			throw new NoSuchElementException();
		}
		T value = secondary.pop();
		
		return value;
	}
	
	public boolean isEmpty() {
		return primary.isEmpty() && secondary.isEmpty();
	}
	
	private void reverse() {
		if(secondary.isEmpty()) {
			while(!primary.isEmpty()) {
				secondary.push(primary.pop());
			}
		}
	}
}
