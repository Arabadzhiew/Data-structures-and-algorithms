package com.arabadzhiev.ood;

import java.util.Iterator;

public class CircularArray <T> implements Iterable<T>{
	private T[] buffer;
	private int size;
	private int count;
	private int beginningIndex;
	private int currentIndex;
	
	@SuppressWarnings("unchecked")
	public CircularArray(int size) {
		this.buffer = (T[]) new Object[size];
		this.size = size;
		this.count = 0;
		this.beginningIndex = 0;
		this.currentIndex = 0;
	}
	
	
	public void add(T value) {
		if(count == size) {
			throw new ArrayIndexOutOfBoundsException("The max size has been reached");
		}
		buffer[currentIndex] = value;
		currentIndex++;
		checkUpperBound();
		count++;
	}
	
	public T get(int index) {
		return buffer[convert(index)];
	}
	
	public void removeFirst() {
		
		buffer[beginningIndex] = null;
		beginningIndex++;
		checkBeginningIndex();
		count--;
	}
	
	public void removeLast() {
		currentIndex--;
		checkLowerBound();
		
		buffer[currentIndex] = null;
		count--;
	}
	
	public void rotateForward() {
		beginningIndex++;
		checkBeginningIndex();
		currentIndex++;
		checkUpperBound();
	}
	
	public void rotateBackward() {
		beginningIndex--;
		if(beginningIndex < 0) {
			beginningIndex = size - 1;
		}
		currentIndex--;
		checkLowerBound();
	}
	
	public int convert(int index) {
		return (beginningIndex + index) % size;
	}
	
	private void checkUpperBound() {
		if(currentIndex >= size) {
			currentIndex = 0;
		}
	}
	
	private void checkLowerBound() {
		if(currentIndex < 0) {
			currentIndex = size - 1;
		}
	}
	
	private void checkBeginningIndex() {
		if(beginningIndex >= size) {
			beginningIndex = 0;
		}
	}


	@Override
	public Iterator<T> iterator() {
		return new CircularIterator();
	}
	
	
	private class CircularIterator implements Iterator<T>{
		
		private int tillEmpty = count;
		private int index = beginningIndex;
		
		@Override
		public boolean hasNext() {
			return tillEmpty != 0;
		}

		@Override
		public T next() {
			T rVal = buffer[index];
			index++;
			if(index >= size) {
				index = 0;
			}
			
			if(rVal == null) {
				return null;
			}
			
			tillEmpty--;
			return rVal;
		}
		
	}
}
