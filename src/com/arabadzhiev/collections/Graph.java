package com.arabadzhiev.collections;

public class Graph {
	
	private ArrayList<Node> nodes;
	private int count;
	
	public Graph() {
		nodes = new ArrayList<>();
		count = 0;
	}
	
	public void addNode(Node node) {
		nodes.add(node);
		count++;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public ArrayList<Node> getNodes(){
		return this.nodes;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public static class Node{
		private String name;
		private State state;
		private ArrayList<Node> children;
		
		public Node(String name) {
			this.name = name;
			this.state = State.UNVISITED;
			this.children = new ArrayList<>();
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public ArrayList<Node> getChildren() {
			return children;
		}
		public void addChild(Node node) {
			this.children.add(node);
		}
		
		public State getState() {
			return state;
		}

		public void setState(State state) {
			this.state = state;
		}



		public enum State{
			VISITED,
			VISITING,
			UNVISITED;
		}
		
	}
}
