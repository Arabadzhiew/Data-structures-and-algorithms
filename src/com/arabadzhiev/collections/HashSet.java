package com.arabadzhiev.collections;

import java.util.Iterator;


public class HashSet<T> implements Iterable<T> {
	
	private LinkedList<T>[] buffer;
	private int size;
	private int bufferLenght;
	
	@SuppressWarnings("unchecked")
	public HashSet() {
		bufferLenght = 8;
		size = 0;
		buffer = (LinkedList<T>[]) new LinkedList[bufferLenght];
	}
	
	public void add(T value) {
		checkForUpdate();
		
		int hash = calculateHashIndex(value.hashCode());
		if(buffer[hash] == null) {
			buffer[hash] = new LinkedList<T>(value);
			size++;
			return;
		}
		
		if(buffer[hash].contains(value)) {
			return;
		}
		size++;
		buffer[hash].add(value);
	}
	
	public boolean contains(T value) {
		int hash = calculateHashIndex(value.hashCode());
		
		return buffer[hash] == null ? false : buffer[hash].contains(value);
	}
	
	public void printAll() {
		for(LinkedList<T> list : buffer) {
			if(list == null) {
				continue;
			}
			
			for(T value : list) {
				System.out.println(value);
			}
		}
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iter();
	}
	
	
	@SuppressWarnings("unchecked")
	private void checkForUpdate() {
		if(size * 2 > bufferLenght) {
			bufferLenght *= 2;
			LinkedList<T>[] newBuffer = (LinkedList<T>[])new LinkedList[bufferLenght];
			for(int i = 0; i < buffer.length; i++) {
				if(buffer[i] == null) {
					continue;
				}
				for(T item : buffer[i]) {
					int hash = calculateHashIndex(item.hashCode());
					
					if(newBuffer[hash] == null) {
						newBuffer[hash] = new LinkedList<T>(item);
					}else {
						newBuffer[hash].add(item);
					}
				}
			}
			this.buffer = newBuffer;
			
		}
	}
	
	private int calculateHashIndex(int hash) {
		return Math.abs(hash) % bufferLenght;
	}
	
	private class Iter implements Iterator<T>{
		
		private int cursor = 0;
		private int currentIndex = 0;
		private int iterated = 0;

		@Override
		public boolean hasNext() {
			return this.iterated < size;
		}

		@Override
		public T next() {
			while(buffer[cursor] == null) {
				cursor++;
			}
			
			if(buffer[cursor].getSize() <= currentIndex) {
				cursor++;
				while(buffer[cursor] == null) {
					cursor++;
				}
				currentIndex = 0;
			}
			T returnVal = buffer[cursor].get(currentIndex);
			currentIndex++;
			iterated++;
			return returnVal;
		}
		
	}

}
