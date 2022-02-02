package com.arabadzhiev.collections;

import java.util.Iterator;

public class ArrayList<T> implements Iterable<T>{
	private Object[] buffer;
	private int size;
	
	public ArrayList(){
		this.buffer = new Object[2];
		size = 0;
	}
	
	public ArrayList(int size) {
		if(size > 0) {
			this.buffer = new Object[size];
			this.size = 0;
		}else {
			throw new IllegalArgumentException("Illegal size: " + size);
		}
		
	}
	
	
	public void add(T element) {
		size++;
		checkForUpdate();
		buffer[size-1] = element;
		
	}
	
	public void add(int index, T element) {
		checkIndex(index,this.size);
		size++;
		checkForUpdate();
		makeSpace(index);
		buffer[index] = element;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index) {
		return (T)buffer[index];
	}
	
	public void remove(int index) {
		checkIndex(index, this.size);
		size--;
		takeSpace(index);
	}
	
	public boolean contains(T value) {
		for(Object o : buffer) {
			if(o.equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	public int getSize() {
		return this.size;
	}
	
	private void checkForUpdate() {
		if(this.size >= buffer.length) {
			Object[] newArray = new Object[buffer.length * 2];
			
			for(int i = 0; i < buffer.length; i++) {
				newArray[i] = buffer[i];
			}
			
			buffer = newArray;
		}
	}
	
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		Object[] returnArray = new Object[size];
		for(int i = 0; i < size; i++) {
			returnArray[i] = buffer[i];
		}
		
		return (T[])returnArray;
	}
	
	private void checkIndex(int index, int size) {
		if(index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + " out of bounds, for Size: " + size);
		}
	}
	
	private void makeSpace(int index) {
		for(int i = size; i > index ; i--) {
			buffer[i] = buffer[i-1];
		}
	}
	
	private void takeSpace(int index) {
		for(int i = index; i <= size - 1; i++) {
			buffer[i] = buffer[i+1];
		}
		buffer[size] = null;
	}


	@Override
	public Iterator<T> iterator() {
		return new Iter();
	}
	
	private class Iter implements Iterator<T>{
		
		private int cursor = 0;

		@Override
		public boolean hasNext() {
			return this.cursor < size;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			T data = null;
			int innerCount = 0;
			while(data == null) {
				data = (T)buffer[cursor + innerCount];
				innerCount++;
			}
			
			cursor++;
			return data;
		}
		
	}
}
