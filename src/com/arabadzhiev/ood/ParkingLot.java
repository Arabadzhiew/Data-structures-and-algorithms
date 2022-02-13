package com.arabadzhiev.ood;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingLot {
	
	private static ParkingLot instance;
	private int size = 100;
	
	private int freeSpots;
	private Spot[] spots = new Spot[size];
	
	protected ParkingLot() {
		for(int i = 0; i < size; i++)	{
			spots[i] = new Spot(i);
		}
		freeSpots = size;
	}
	
	public static ParkingLot getInstance() {
		if(instance == null) {
			instance = new ParkingLot();
		}
		
		return instance;
	}
	
	public Spot getFreeSpot() {
		if(isFull()) {
			return null;
		}
		
		for(Spot s : spots) {
			if(s.isFree()) {
				freeSpots--;
				return s;
			}
		}
		
		return null;
	}
	
	public void checkoutCar(Car car) {
		
		long hoursStayed = car.getParkedSince().until(LocalDateTime.now(), ChronoUnit.HOURS) + 1;
		
		System.out.println("You stayed for a total of: " + hoursStayed + 
				" hour. Your charge is: " + (hoursStayed * 3) + " BGN.");
		
		freeSpots++;
	}
	
	public boolean isFull() {
		return this.freeSpots == 0;
	}
	
	
}
