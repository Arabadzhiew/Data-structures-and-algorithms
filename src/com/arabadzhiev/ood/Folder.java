package com.arabadzhiev.ood;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Entity{
	
	private List<Entity> children;
	private int childrenCount;
	
	public Folder(String name, Folder parent) {
		super(name, parent);
		children = new ArrayList<>();
		childrenCount = 0;
	}
	
	public List<Entity> getChildren(){
		return children;
	}
	
	public void addChild(Entity e) {
		children.add(e);
		childrenCount++;
	}
	
	public int getChildCount() {
		return childrenCount;
	}
}
