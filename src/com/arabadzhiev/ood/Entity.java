package com.arabadzhiev.ood;

import java.time.LocalDateTime;

public abstract class Entity {
	
	private Folder parent;
	private String name;
	private LocalDateTime lastModified;
	
	protected Entity(String name, Folder parent) {
		this.name = name;
		this.parent = parent;
		this.lastModified = LocalDateTime.now();
		
	}
	
	public Folder getParent() {
		return parent;
	}

	public void setParent(Folder parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDateTime getLastModified() {
		return lastModified;
	}
	
	public void updateLastModified() {
		lastModified = LocalDateTime.now();
	}
	
	
}
