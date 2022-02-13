package com.arabadzhiev.ood;

import java.time.LocalDateTime;

public class Car {
	private String licencePlate;
	private LocalDateTime parkedSince;
	private Spot spot;
	
	protected ParkingLot parking = ParkingLot.getInstance();
	
	public Car(String licencePlate) {
		this.licencePlate = licencePlate;
		parkedSince = LocalDateTime.now();
	}
	
	public void park() {
		parking.getFreeSpot().addCar(this);
	}
	
	public void leave() {
		parking.checkoutCar(this);
		this.spot.setFree(true);
		this.spot.removeCar();
	}

	public String getLicencePlate() {
		return licencePlate;
	}

	public LocalDateTime getParkedSince() {
		return parkedSince;
	}
	
	public void setSpot(Spot spot) {
		this.spot = spot;
	}
	
	public Spot getSpot() {
		return this.spot;
	}
	
	
}
