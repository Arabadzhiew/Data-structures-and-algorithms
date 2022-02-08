package com.arabadzhiev.snq;

import java.util.EmptyStackException;

public class ArrayTrippleStack<T> {
	
	private int indexFirst = 0;
	private int sizeFirst = 0;
	private int indexSecond = 4;
	private int sizeSecond = 0;
	private int indexThird = 8;
	private int sizeThird = 0;
	
	private Object[] buffer;
	
	public ArrayTrippleStack() {
		buffer = new Object[12];
	}
	
	public void addToFirst(T value) {
		if(indexFirst + sizeFirst == indexSecond) {
			Object[] replacement = new Object[buffer.length + sizeFirst];
			indexSecond += sizeFirst;
			indexThird += sizeFirst;
			
			for(int i = 0; i < sizeFirst; i++) {
				replacement[i] = buffer[i];
			}
		
			for(int i = indexSecond; i < replacement.length; i++) {
				replacement[i] = buffer[i - sizeFirst];
			}
			
			buffer = replacement;
		}
		buffer[indexFirst + sizeFirst] = value;
		sizeFirst++;
	}
	
	public void addToSecond(T value) {
		if(indexSecond + sizeSecond == indexThird) {
			Object[] replacement = new Object[buffer.length + sizeSecond];
			indexThird += sizeSecond;
			
			for(int i = 0; i < indexSecond + sizeSecond; i++) {
				replacement[i] = buffer[i];
			}
			
			for(int i = indexThird; i < replacement.length; i++) {
				replacement[i] = buffer[i - sizeSecond];
			}
			
			buffer = replacement;
		}
		buffer[indexSecond + sizeSecond] = value;
		sizeSecond++;
	}

	public void addToThird(T value) {
		if(indexThird + sizeThird == buffer.length) {
			Object[] replacement = new Object[buffer.length + sizeThird];
			
			for(int i = 0; i < buffer.length; i++) {
				replacement[i] = buffer[i];
			}
			
			buffer = replacement;
		}
		buffer[indexThird + sizeThird] = value;
		sizeThird++;
	}
	
	@SuppressWarnings("unchecked")
	public T peekFromFirst() {
		if(sizeFirst == 0) {
			throw new EmptyStackException();
		}
		return (T) buffer[indexFirst + sizeFirst - 1]; 
	}
	
	@SuppressWarnings("unchecked")
	public T peekFromSecond() {
		if(sizeSecond == 0) {
			throw new EmptyStackException();
		}
		return (T) buffer[indexSecond + sizeSecond - 1]; 
	}
	
	@SuppressWarnings("unchecked")
	public T peekFromThird() {
		if(sizeThird == 0) {
			throw new EmptyStackException();
		}
		return (T) buffer[indexThird + sizeThird - 1]; 
	}
	
	
	public T popFromFirst() {
		T value = peekFromFirst();
		
		buffer[indexFirst + sizeFirst - 1] = null;
		sizeFirst--;
		
		return value;
	}
	
	public T popFromSecond() {
		T value = peekFromSecond();
		
		buffer[indexSecond + sizeSecond - 1] = null;
		sizeSecond--;
		
		return value;
	}
	
	public T popFromThird() {
		T value = peekFromThird();
		
		buffer[indexThird + sizeThird - 1] = null;
		sizeThird--;
		
		return value;
	}
	
	public boolean firstIsEmpty() {
		return sizeFirst == 0;
	}
	
	public boolean secondIsEmpty() {
		return sizeSecond == 0;
	}
	
	public boolean thirdIsEmpty() {
		return sizeThird == 0;
	}
	
}
