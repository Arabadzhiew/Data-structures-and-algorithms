package com.arabadzhiev.ood;

public class Employee {
	private String name;
	private int skillLevel;
	private boolean free;
	
	public Employee(String name) {
		this.name = name;
		this.free = true;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}
	
	public int getSkillLevel() {
		return this.skillLevel;
	}
	
	public void setStatus(boolean free) {
		this.free = free;
	}
	
	public boolean isFree() {
		return this.free;
	}
}
