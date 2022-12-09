package com.parkinglot.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.parkinglot.exception.ParkingNotFoundException;
import com.parkinglot.model.Parking;
import com.parkinglot.repository.ParkingRepository;

@Service
public class ParkingService {
	private ParkingRepository repository;

	public ParkingService(ParkingRepository repository) {
		this.repository = repository;
	}

	/*
	 * Data in memory for test private static Map<String, Parking> parkingMap = new
	 * HashMap(); static { var id = getUUID(); //Parking parking = new
	 * Parking(id,"DMS-111","SC","Celta","black"); Parking parking =
	 * Parking.builder() .id(id).state("SC").color("black")
	 * .model("Celta").license("DMS-1111") .build(); parkingMap.put(id, parking); id
	 * = getUUID(); Parking parking2 = Parking.builder()
	 * .id(id).state("SP").color("red") .model("VW GOL").license("WAS-1234")
	 * .build(); parkingMap.put(id, parking2); }
	 */

	@Transactional(readOnly =true, propagation = Propagation.SUPPORTS)
	public List<Parking> findAll() {
		return repository.findAll();
	}
	@Transactional(readOnly =true)
	public Parking findById(String id) {
		// Returns a optional
		return repository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));
	}

	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	@Transactional
	public Parking create(Parking parkingCreate) {
		parkingCreate.setId(getUUID());
		parkingCreate.setEntryData(LocalDateTime.now());
		repository.save(parkingCreate);
		return parkingCreate;
	}

	@Transactional
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);

	}
	
	@Transactional
	public Parking update(String id, Parking parkingCreate) {
		Parking parking = findById(id);
		if (parkingCreate.getColor() != null)
			parking.setColor(parkingCreate.getColor());
		if (parkingCreate.getState() != null)
			parking.setState(parkingCreate.getState());
		if (parkingCreate.getModel() != null)
			parking.setModel(parkingCreate.getModel());
		if (parkingCreate.getLicense() != null)
			parking.setLicense(parkingCreate.getLicense());
		repository.save(parking);
		return parking;
	}

	@Transactional
	public Parking checkOut(String id) {
		Parking parking = findById(id);
		parking.setExitDate(LocalDateTime.now());
		
		//Calling checkout business rules
		parking.setBill(ParkingCheckOut.getBill(parking));
		repository.save(parking);
		return parking;
	}

}
