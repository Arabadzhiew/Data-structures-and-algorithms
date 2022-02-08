package com.arabadzhiev.collections;

import java.util.NoSuchElementException;

public class Queue<T> {
	
	QueueNode<T> beggining;
	QueueNode<T> end;
	
	public void add(T value) {
		QueueNode<T> n = new QueueNode<>(value);
		if(end == null) {
			end = n;
			beggining = n;
			return;
		}
		beggining.next = n;
		beggining = n;
	}
	
	public T peek() {
		if(end == null) {
			throw new NoSuchElementException();
		}
		
		return end.data;
	}
	
	public T remove() {
		T value = peek();
		
		end = end.next;
		
		if(end == null) {
			beggining = null;
		}
		
		return value;
	}
	
	public boolean isEmpty() {
		return end == null;
	}
	
	private static class QueueNode<T>{
		private T data;
		private QueueNode<T> next;
		
		public QueueNode(T data) {
			this.data = data;
		}
		
	}
}
