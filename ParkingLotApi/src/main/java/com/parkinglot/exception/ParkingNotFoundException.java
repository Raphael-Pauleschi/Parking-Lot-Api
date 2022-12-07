package com.parkinglot.exception;

public class ParkingNotFoundException extends RuntimeException {

	public ParkingNotFoundException(String id) {
		super("Parking not found with id : "+id);
	}
	
}