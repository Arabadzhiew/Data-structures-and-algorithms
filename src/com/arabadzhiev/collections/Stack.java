package com.arabadzhiev.collections;

import java.util.EmptyStackException;

public class Stack<T> {
	
	private StackNode<T> top;
	
	public T pop() {
		if(top == null) {
			throw new EmptyStackException();
		}
		T value = this.top.data;
		
		top = top.next;
		
		return value;
	}
	
	public void push(T value) {
		StackNode<T> n = new StackNode<>(value);
		
		n.next = top;
		top = n;
	}
	
	public T peek() {
		if(top == null) {
			throw new EmptyStackException();
		}
		return top.data;
	}
	
	
	private static class StackNode<T>{
		private T data;
		private StackNode<T> next;
		
		public StackNode(T data) {
			this.data = data;
		}
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
}
