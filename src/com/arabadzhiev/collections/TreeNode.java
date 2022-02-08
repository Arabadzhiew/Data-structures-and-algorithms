package com.arabadzhiev.collections;

public class TreeNode<T> {
	private T value;
	private TreeNode<T> parent;
	private ArrayList<TreeNode<T>> children;
	
	public TreeNode(T value) {
		this.value = value;
		this.children = new ArrayList<>();
	}
	
	public T getValue() {
		return this.value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public TreeNode<T> getParent(){
		return this.parent;
	}
	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}
	public ArrayList<TreeNode<T>> getChildren() {
		return this.children;
	}
	public void addChild(TreeNode<T> child) {
		this.children.add(child);
	}
	
}
