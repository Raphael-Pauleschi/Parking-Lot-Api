package com.parkinglot.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Parking {
	private String id;
	private String license;
	private String model;
	private String color;
	private String state;
	private LocalDateTime entryData;
	private LocalDateTime exitDate;
	private Double bill;
}
