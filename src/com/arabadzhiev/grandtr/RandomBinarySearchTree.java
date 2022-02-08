package com.arabadzhiev.grandtr;

import java.util.LinkedList;
import java.util.Stack;

import com.arabadzhiev.collections.BinaryTreeNode;

public class RandomBinarySearchTree {
	private BinaryTreeNode<Integer> root;
	private int size = 0;
	
	public RandomBinarySearchTree(Integer value) {
		this.root = new BinaryTreeNode<Integer>(value);
		size++;
	}
	
	public void insert(Integer value) {
		if(root == null) {
			root = new BinaryTreeNode<>(value);
			size++;
			return;
		}
		
		BinaryTreeNode<Integer> current = root;
		
		while(current != null) {
			Integer currentVal = current.getValue();
			if(value < currentVal) {
				if(current.getLeft() == null) {
					current.setLeft(new BinaryTreeNode<>(value));
					break;
				}
				current = current.getLeft();
				continue;
			}else if(value >= currentVal) {
				if(current.getRight() == null) {
					current.setRight(new BinaryTreeNode<>(value));
					break;
				}
				current = current.getRight();
			}
		}
		size++;
	}
	
	public BinaryTreeNode<Integer> find(Integer value){
		
		if(root == null) {
			return null;
		}
		
		LinkedList<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.push(root);
		
		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer> current = queue.pop();
			
			if(current.getValue().equals(value)) {
				return current;
			}
			
			if(current.getLeft() != null) {
				queue.push(current.getLeft());
			}
			if(current.getRight() != null) {
				queue.push(current.getRight());
			}
		}
		
		return null;
	}
	
	public boolean remove(Integer value) {
		BinaryTreeNode<Integer> node = find(value);
		
		if(node == null) {
			return false;
		}
		
		if(node.getLeft() == null && node.getRight() == null) {
			if(node.getParent().getLeft().equals(node)) {
				node.getParent().setLeft(null);
			}else {
				node.getParent().setRight(null);
			}
			size--;
			return true;
		}
		
		if(node.getRight() == null) {
			if(node.getParent().getLeft() != null && node.getParent().getLeft().equals(node)) {
				node.getParent().setLeft(node.getLeft());
			}else {
				node.getParent().setRight(node.getRight());
			}
			size--;
			return true;
		}
		
		BinaryTreeNode<Integer> replacement = node.getRight();
		
		
		while(replacement.getLeft() != null) {
			replacement = replacement.getLeft();
		}
		
		
		if(replacement.getRight() != null && !replacement.equals(replacement.getParent().getRight())) {
			replacement.getParent().setLeft(replacement.getRight());
		}
		
		
		
		replacement.setLeft(node.getLeft());
		if(!node.getRight().equals(replacement)) {
			replacement.setLeft(node.getRight());
		}
		
		if(node.getParent() == null) {
			this.root = replacement;
			size--;
			return true;
		}
		
		
		if(node.getParent().getLeft().equals(node)) {
			node.getParent().setLeft(replacement);
		}else {
			node.getParent().setRight(replacement);
		}
		
		size--;
		
		return true;
	}
	
	public BinaryTreeNode<Integer> getRandom(){
		if(this.root == null) {
			return null;
		}
		
		long seed = System.nanoTime();
		
		long iterations = seed % (this.size);
		
		Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
		stack.push(this.root);
		
		for(int i = 0; i < iterations; i++) {
			BinaryTreeNode<Integer> current = stack.pop();
			
			if(current.getLeft() != null) {
				stack.push(current.getLeft());
			}
			if(current.getRight() != null) {
				stack.push(current.getRight());
			}
		}
		return stack.pop();
	}
	
	public BinaryTreeNode<Integer> getRoot(){
		return this.root;
	}
	
	public int getSize() {
		return this.size;
	}
	
	
}
