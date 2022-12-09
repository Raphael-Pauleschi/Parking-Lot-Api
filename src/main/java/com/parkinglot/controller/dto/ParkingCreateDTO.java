package com.parkinglot.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingCreateDTO {
	private String license;
	private String model;
	private String color;
	private String state;
	
	public ParkingCreateDTO() {}
	
	public ParkingCreateDTO(String license, String state, String model, String color) {
		super();
		this.license = license;
		this.state = state;
		this.model = model;
		this.color = color;
	}
}
