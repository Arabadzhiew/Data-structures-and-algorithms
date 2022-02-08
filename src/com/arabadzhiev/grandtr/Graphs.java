package com.arabadzhiev.grandtr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.arabadzhiev.collections.Graph;
import com.arabadzhiev.collections.Graph.Node;
import com.arabadzhiev.collections.Graph.Node.State;

public class Graphs {
	
	public static boolean pathExists(Graph graph, Node n1, Node n2) {
		if(n1.equals(n2)) {
			return true;
		}
		
		for(Node n : graph.getNodes()) {
			n.setState(State.UNVISITED);
		}
		
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(n1);
		
		while(!queue.isEmpty()) {
			for(Node n : queue.removeLast().getChildren()) {
				if(n.getState().equals(State.UNVISITED)) {
					if(n.equals(n2)) {
						return true;
					}
					n.setState(State.VISITED);
					queue.add(n);
				}
			}
		}
		return false;
	}
	
	public static Project[] buildOrder(String[] projects, String[][] dependencies) {
		ProjectGraph graph = generateGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
	}
	
	private static ProjectGraph generateGraph(String[] projects, String[][] dependencies) {
		ProjectGraph graph = new ProjectGraph();
		for(String name : projects) {
			graph.addNode(name);
		}
		
		for(String[] pair : dependencies) {
			String dependency = pair[0];
			String project = pair[1];
			graph.addEdge(dependency, project);
		}
		return graph;
	}
	
	private static Project[] orderProjects(List<Project> projects) {
		Project[] order = new Project[projects.size()];
		
		int endOfList = addNonDependent(order, projects, 0);
		
		int toBeProcessed = 0;

		
		while(toBeProcessed < order.length) {
			Project current = order[toBeProcessed];
			
			if(current == null) {
				return null;
			}
			
			List<Project> children = current.getChildren();
			for(Project child : children) {
				child.decrementDependencies();
			}
			
			endOfList = addNonDependent(order, children, endOfList);
			toBeProcessed++;
		}
		return order;
	}
	
	private static int addNonDependent(Project[] order, List<Project> projects, int offset) {
		for(Project p : projects) {
			if(p.getDependencies() == 0) {
				order[offset] = p;
				offset++;
			}
		}
		return offset;
	}
	
	public static class Project{
		private String name;
		private int dependencies = 0;
		private List<Project> children = new ArrayList<>();
		private Map<String, Project> map = new HashMap<>();
		
		public Project(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		
		public int getDependencies() {
			return this.dependencies;
		}
		public List<Project> getChildren(){
			return this.children;
		}
		
		public void addNeighbour(Project p) {
			if(!map.containsKey(p.getName())) {
				children.add(p);
				map.put(p.getName(), p);
				p.incrementDependencies();
			}
		}
		
		
		public void incrementDependencies() {
			this.dependencies++;
		}
		
		public void decrementDependencies() {
			this.dependencies--;
		}
	}
	
	public static class ProjectGraph{
		private List<Project> nodes = new ArrayList<>();
		private Map<String, Project> map = new HashMap<>();
		
		public Project getOrCreate(String name) {
			if(!map.containsKey(name)) {
				Project project = new Project(name);
				nodes.add(project);
				map.put(name, project);
			}
			return map.get(name);
		}
		
		public void addNode(String name) {
			if(map.containsKey(name)) {
				return;
			}
			
			Project project = new Project(name);
			nodes.add(project);
			map.put(name, project);
		}
		
		public void addEdge(String dependency, String project) {
			Project start = getOrCreate(dependency);
			Project end = getOrCreate(project);
			start.addNeighbour(end);
			
		}
		
		public List<Project> getNodes(){
			return this.nodes;
		}
	}
}
