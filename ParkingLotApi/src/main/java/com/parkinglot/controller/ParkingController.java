package com.parkinglot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkinglot.controller.dto.ParkingCreateDTO;
import com.parkinglot.controller.dto.ParkingDTO;
import com.parkinglot.controller.mapper.ParkingMapper;
import com.parkinglot.model.Parking;
import com.parkinglot.service.ParkingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cars")
@Api(tags = "Parking Controller")
public class ParkingController {
	//Padrão recomendado na injeção de depências é por construtor
	
	private final ParkingService service;
	private final ParkingMapper parkingMapper;
	
	public ParkingController(ParkingService service, ParkingMapper parkingMapper) {
		this.service = service;
		this.parkingMapper = parkingMapper;
	}
	

	@GetMapping
	@ApiOperation("Find all parkings")
	public ResponseEntity<List<ParkingDTO>> findAll(){
		List<Parking> parkingList = service.findAll();
		List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/{id}")
	@ApiOperation("Find by Id")
	public ResponseEntity<ParkingDTO> findById(@PathVariable String id){
		Parking parking = service.findById(id);
	/*	if(parking == null) {
			return ResponseEntity.notFound().build();
		}*/
		ParkingDTO result = parkingMapper.toParkingDTO(parking);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation("Delete by Id")
	public ResponseEntity delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	@ApiOperation("Create parking")
	public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto){
		Parking parkingCreate = parkingMapper.toParkingCreate(dto);
		Parking parking = service.create(parkingCreate);
		ParkingDTO result = parkingMapper.toParkingDTO(parking);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);		
	}
	
	@PutMapping("/{id}")
	@ApiOperation("Update a parking")
	public ResponseEntity<ParkingDTO> update(@PathVariable String id,@RequestBody ParkingCreateDTO dto){
		Parking parkingUpdate = parkingMapper.toParkingCreate(dto);
		Parking parking = service.update(id, parkingUpdate);
		return ResponseEntity.ok(parkingMapper.toParkingDTO(parking));
	}
	
	
} 