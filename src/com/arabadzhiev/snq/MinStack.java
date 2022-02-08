package com.arabadzhiev.snq;

import java.util.EmptyStackException;

import com.arabadzhiev.collections.Stack;

public class MinStack {
	
	private StackNode next;
	private Stack<Integer> mins;
	
	public MinStack() {
		mins = new Stack<>();
	}
	
	public void push(Integer value) {
		
		StackNode n = new StackNode(value);
		
		if(mins.isEmpty() || mins.peek() >= value) {
			mins.push(value);
		}
		
		if(next == null) {
			next = n;
			return;
		}
		
		n.next = next;
		next = n;
	}
	
	public Integer peek() {
		if(next == null) {
			throw new EmptyStackException();
		}
		
		return next.value;
	}
	
	public Integer pop() {
		Integer value = peek();
		
		if(next.value == mins.peek()) {
			mins.pop();
		}
		
		next = next.next;
		return value;
	}
	
	public Integer min() {
		if(mins.peek() == null) {
			throw new EmptyStackException();
		}
		
		return mins.peek();
	}
	
	public boolean isEmpty(){
		return next == null;
	}
	
	private static class StackNode{
		private Integer value;
		private StackNode next;
		
		public StackNode(Integer value) {
			this.value = value;
		}
	}
}
