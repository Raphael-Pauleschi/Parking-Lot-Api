package com.parkinglot.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Parking {
	@Id
	private String id;
	private String license;
	private String model;
	private String color;
	private String state;
	private LocalDateTime entryData;
	private LocalDateTime exitDate;
	private Double bill;

	public Parking() {}
	
	public Parking(String id, String license, String state, String model, String color) {
		super();
		this.id = id;
		this.license = license;
		this.state = state;
		this.model = model;
		this.color = color;
	}
	
}
