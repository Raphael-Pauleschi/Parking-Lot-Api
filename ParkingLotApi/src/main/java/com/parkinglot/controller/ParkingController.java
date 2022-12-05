package com.parkinglot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkinglot.model.Parking;

@RestController
@RequestMapping("/cars")
public class ParkingController {
	
	@GetMapping
	public List<Parking> findAll(){
		var parking = new Parking();
		
		parking.setColor("Black");
		parking.setLicense("MSS-1111");
		parking.setModel("VR GOL");
		parking.setState("SP");
		
		return Arrays.asList(parking,parking);
		
	}
}
