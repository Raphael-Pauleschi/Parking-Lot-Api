package com.parkinglot.controller.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
@Builder
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParkingDTO {
	
	private String id;
	private String license;
	private String model;
	private String color;
	private String state;
	@JsonFormat(pattern = "MM/dd/yyyy HH:mm")
	private LocalDateTime entryData;
	@JsonFormat(pattern = "MM/dd/yyyy HH:mm")
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
