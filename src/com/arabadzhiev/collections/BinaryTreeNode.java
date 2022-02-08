package com.arabadzhiev.collections;

public class BinaryTreeNode <T>{
	private T value;
	private BinaryTreeNode<T> parent;
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	
	public BinaryTreeNode(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return this.value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public BinaryTreeNode<T> getParent() {
		return this.parent;
	}
	
	public void setParent(BinaryTreeNode<T> parent) {
		this.parent = parent;
	}
	
	public BinaryTreeNode<T> getLeft(){
		return this.left;
	}
	
	public void setLeft(BinaryTreeNode<T> left) {
		if(left != null) {
			left.setParent(this);
		}
		this.left = left;
	}
	
	public BinaryTreeNode<T> getRight(){
		return this.right;
	}
	
	public void setRight(BinaryTreeNode<T> right) {
		if(right != null) {
			right.setParent(this);
		}
		this.right = right;
	}
	
}
