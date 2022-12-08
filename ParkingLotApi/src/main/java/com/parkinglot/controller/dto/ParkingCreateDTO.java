package com.parkinglot.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ParkingCreateDTO {
	private String license;
	private String model;
	private String color;
	private String state;
}
