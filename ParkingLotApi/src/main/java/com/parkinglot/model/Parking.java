package com.parkinglot.model;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Parking {
	private String id;
	private String license;
	private String model;
	private String color;
	private String state;
	private LocalDateTime entryData;
	private LocalDateTime exitDate;
	private Double bill;
/*
	public Parking() {}
	
	public Parking(String id, String license, String state, String model, String color) {
		super();
		this.id = id;
		this.license = license;
		this.state = state;
		this.model = model;
		this.color = color;
	}
	*/
	
}
