package com.arabadzhiev.collections;

import java.util.Iterator;

public class HashMap <K, V> implements Iterable<V>{
	
	private ArrayList<Node>[] storage;
	private int size;
	private int storageLenght;
	
	@SuppressWarnings("unchecked")
	public HashMap(){
		size = 0;
		storageLenght = 8;
		storage =  (ArrayList<Node>[])new ArrayList[storageLenght];
	}
	
	public void add(K key, V value) {
		checkForUpdate();
		
		Node insertionNode = new Node(key, value);
		
		int hash = calculateHash(insertionNode.hashCode());
		
		if(storage[hash] == null) {
			storage[hash] = new ArrayList<Node>();
		}
		storage[hash].add(insertionNode);
		size++;
	}
	
	public V get(K key) {
		int hash = calculateHash(key.hashCode());
		
		if(storage[hash] == null) {
			return null;
		}
		
		for(Node n : storage[hash]) {
			if(n.hashCode() == key.hashCode()) {
				return n.getValue();
			}
		}
		return null;
	}
	
	public boolean contains(K key) {
		int hash = calculateHash(key.hashCode());
		if(storage[hash] == null) {
			return false;
		}
		
		for(Node n : storage[hash]) {
			if(n.hashCode() == key.hashCode()) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public Iterator<V> iterator() {
		return new Iter();
	}
	
	private int calculateHash(int hash) {
		return Math.abs(hash) % this.storageLenght;
	}
	
	@SuppressWarnings("unchecked")
	private void checkForUpdate() {
		if(size * 2 > storageLenght) {
			ArrayList<Node>[] newStorage = (ArrayList<Node>[]) new ArrayList[storageLenght * 2];
			for(ArrayList<Node> list : storage) {
				if(list == null) {
					continue;
				}
				for(Node n : list) {
					int hash = calculateHash(n.hashCode());
					if(newStorage[hash] == null) {
						newStorage[hash] = new ArrayList<Node>();
					}
					newStorage[hash].add(n);
				}
			}
			
			storage = newStorage;
		}
	}
	
	private class Iter implements Iterator<V>{
		
		private int cursor = 0;
		private int currentIndex = 0;
		private int innerIndex = 0;

		@Override
		public boolean hasNext() {
			return this.cursor < size;
		}

		@Override
		public V next() {
			while(storage[currentIndex] == null) {
				currentIndex++;
				if(innerIndex != 0) {
					innerIndex = 0;
				}
			}
			
			V returnVal = storage[currentIndex].get(innerIndex).getValue();
			
			if( storage[currentIndex].get(innerIndex + 1) == null) {
				currentIndex++;
				innerIndex = 0;
				cursor++;
				return returnVal;
			}
			
			cursor++;
			innerIndex++;
			return returnVal;
		}
		
	}
	
	private class Node{
		private K key;
		private V value;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public V getValue() {
			return value;
		}
		
		@Override
		public int hashCode() {
			return this.key.hashCode();
		}
		
	}
}
