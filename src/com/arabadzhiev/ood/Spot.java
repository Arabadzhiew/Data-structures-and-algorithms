package com.arabadzhiev.ood;

public class Spot {
	
	private int id;
	private boolean free;
	private Car current;
	
	public Spot(int id) {
		this.id = id;
		this.free = true;
	}
	
	public Spot(int id, Car current) {
		this.id = id;
		this.current = current;
		this.free = false;
	}
	
	public boolean isFree() {
		return free;
	}
	public void setFree(boolean free) {
		this.free = free;
	}
	public Car getCurrent() {
		return current;
	}
	public void addCar(Car current) {
		current.setSpot(this);
		this.free = false;
		this.current = current;
	}
	public void removeCar() {
		this.free = true;
		this.current = null;
	}
	public int getId() {
		return id;
	}
	
	
}
