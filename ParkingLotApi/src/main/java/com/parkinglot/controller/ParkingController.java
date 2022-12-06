package com.parkinglot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<List<ParkingDTO>> findAll(){
		List<Parking> parkingList = service.findAll();
		List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ParkingDTO> findById(@PathVariable String id){
		Parking parking = service.findById(id);
		ParkingDTO result = parkingMapper.toParkingDTO(parking);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping
	public ResponseEntity<ParkingDTO> create(@RequestBody ParkingDTO dto){
		Parking parkingCreate = parkingMapper.toParking(dto);
		Parking parking = service.create(parkingCreate);
		ParkingDTO result = parkingMapper.toParkingDTO(parking);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);		
	}
}
