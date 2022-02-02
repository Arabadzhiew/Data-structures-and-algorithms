package com.arabadzhiev.collections;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{
	private Node<T> current;
	private Node<T> first;
	private Node<T> last;
	
	private int size;
	
	public LinkedList(T initialValue) {
		current = new Node<T>(initialValue, null);
		first = current;
		last = current;
		size = 1;
	}
	
	public LinkedList() {
		current = null;
		first = null;
		last = null;
		size = 0;
	}
	
	public void add(T value) {
		if(first == null) {
			first = new Node<T>(value);
			last = first;
			current = first;
			
			size ++;
			return;
		}
		last.setNext(new Node<T>(value));
		last = last.getNext();
		size ++;
	}
	
	public void add(int index, T value) {
		
		if(index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + " out of bounds for Size: " + this.size);
		}else if(index == size) {
			add(value);
			return;
		}
		
		if(this.first == null) {
			add(value);
			System.out.println("gr");
			return;
		}
		
		Node<T> node = first;
		
		for(int i = 1; i < index; i++) {
			node = node.getNext();
		}
		
		Node<T> newNode = new Node<T>(value, node.getNext());
		node.setNext(newNode);
		
	}
	
	public T get(int index) {
		if(index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + " out of bounds for Size: " + this.size);
		}
		
		Node<T> node = first;
		
		for(int i = 0; i < index; i ++) {
			node = node.getNext();
		}
		
		return node.getValue();
	}
	
	public Node<T> getFirstNode() {
		return this.first;
	}
	
	public void remove(int index) {
		if(index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + " out of bounds for Size: " + this.size);
		}
		
		if(index == 0) {
			this.first = this.first.getNext();
			size--;
			return;
		}
		
		Node<T> node = this.getFirstNode();
		
		for(int i = 0; i < index - 1; i++) {
			node = node.getNext();
		}
		
		Node<T> removeNode = node.getNext();
		Node<T> replaceNode = removeNode.getNext();
		
		node.setNext(replaceNode);
		if(replaceNode == null) {
			this.last = node;
		}
		size--;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public boolean contains(T value) {
		Node<T> loopNode = first;
		while(loopNode != null) {
			if(loopNode.getValue().equals(value)) {
				return true;
			}
			loopNode = loopNode.getNext();
		}
		return false;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iter();
	}
	
	public static class Node<E>{
		private E value;
		private Node<E> next;
		
		
		public Node(E value) {
			this.value = value;
			this.next = null;
		}
		
		public Node(E value, Node<E> next) {
			this.value = value;
			this.next = next;
		}
		
		public E getValue() {
			return this.value;
		}
		
		
		public Node<E> getNext() {
			return this.next;
		}
		
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
	
	private class Iter implements Iterator<T>{
		
		Node<T> cursor = first;

		@Override
		public boolean hasNext() {
			return !(cursor == null);
		}

		@Override
		public T next() {
			T returnVal = cursor.getValue();
			cursor = cursor.getNext();
			return returnVal;
		}
		
	}

}
