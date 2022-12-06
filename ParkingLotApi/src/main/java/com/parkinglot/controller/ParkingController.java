package com.parkinglot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkinglot.controller.dto.ParkingDTO;
import com.parkinglot.controller.mapper.ParkingMapper;
import com.parkinglot.model.Parking;
import com.parkinglot.service.ParkingService;

@RestController
@RequestMapping("/cars")
public class ParkingController {
	
	//Padrão recomendado na injeção de depências é por construtor
	
	private final ParkingService service;
	private final ParkingMapper parkingMapper;
	
	public ParkingController(ParkingService service, ParkingMapper parkingMapper) {
		this.service = service;
		this.parkingMapper = parkingMapper;
	}
	
	

	@GetMapping
	public List<ParkingDTO> findAll(){
		List<Parking> parkingList = service.findAll();
		List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
		return result;
	}
}
