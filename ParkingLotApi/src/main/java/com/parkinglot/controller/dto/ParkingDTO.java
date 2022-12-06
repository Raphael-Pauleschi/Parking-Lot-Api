package com.parkinglot.controller.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Builder
@Value
public class ParkingDTO {
	
	private String id;
	private String license;
	private String model;
	private String color;
	private String state;
	private LocalDateTime entryData;
	private LocalDateTime exitDate;
	private Double bill;
/*
public ParkingDTO() {}
	
	public ParkingDTO(String id, String license, String state, String model, String color) {
		super();
		this.id = id;
		this.license = license;
		this.state = state;
		this.model = model;
		this.color = color;
	}
	*/
}
