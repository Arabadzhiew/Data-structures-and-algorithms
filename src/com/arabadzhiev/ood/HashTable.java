package com.arabadzhiev.ood;

import com.arabadzhiev.collections.LinkedListNode;

public class HashTable <K, V>{
	
	private LinkedListNode<Node>[] chain;
	private int count;
	private int chainSize;
	
	@SuppressWarnings("unchecked")
	public HashTable() {
		chainSize = 8;
		count = 0;
		chain = new LinkedListNode[chainSize];
	}
	
	public boolean add(K key, V value) {
		if(contains(key)) {
			return false;
		}
		
		checkForResize();
		add(key, value, this.chain);
		
		return true;
	}
	
	public V get(K key) {
		int index = calculateIndex(key);
		LinkedListNode<Node> current = chain[index];
		
		while(current != null) {
			if(current.getValue().getKey().equals(key)) {
				return current.getValue().getValue();
			}
			current = current.getNext();
		}
		
		return null;
	}
	
	public boolean remove(K key) {
		if(!contains(key)) {
			return false;
		}
		
		int index = calculateIndex(key);
		
		if(!chain[index].hasNext()) {
			chain[index] = null;
			return true;
		}else if(chain[index].getValue().getKey().equals(key)) {
			chain[index] = chain[index].getNext();
			return true;
		}
		
		
		LinkedListNode<Node> previous = chain[index];
		LinkedListNode<Node> target = chain[index].getNext();
		
		while(target != null) {
			if(target.getValue().getKey().equals(key)) {
				previous.setNext(target.getNext());
				return true;
			}
			previous = target;
			target = target.getNext();
		}
		
		return false;
	}
	
	public boolean contains(K key) {
		for(LinkedListNode<Node> node : chain) {
			while(node != null) {
				if(node.getValue().getKey().equals(key)) {
					return true;
				}
				
				node = node.getNext();
			}
		}
		return false;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	private void add(K key, V value, LinkedListNode<Node>[] chain) {
		int index = calculateIndex(key);
		
		if(chain[index] == null) {
			chain[index] = new LinkedListNode<>(new Node(key, value));
			count++;
			return;
		}
		
		LinkedListNode<Node> current = chain[index];
		
		while(current.getNext() != null) {
			current = current.getNext();
		}
		
		current.setNext(new LinkedListNode<>(new Node(key, value)));
		count++;
	}
	
	
	
	private int calculateIndex(K key) {
		return Math.abs(key.hashCode() % chainSize);
	}
	
	@SuppressWarnings("unchecked")
	private void checkForResize() {
		if(count >= chain.length / 2) {
			chainSize = chainSize * 2;
			LinkedListNode<Node>[] newChain = new LinkedListNode[chainSize];
			
			for(LinkedListNode<Node> node : chain) {
				while(node != null) {
					add(node.getValue().getKey(), node.getValue().getValue(), newChain);
					node = node.getNext();
				}
			}
			
			chain = newChain;
		}
	}
	
	private class Node{
		private K key;
		private V value;
		
		private Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		private K getKey() {
			return key;
		}

		private V getValue() {
			return value;
		}

		
	}
}
