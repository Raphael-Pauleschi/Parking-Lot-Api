package com.parkinglot.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

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

	public List<Parking> findAll() {
		return repository.findAll();
	}

	public Parking findById(String id) {
		// Returns a optional
		return repository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));
	}

	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public Parking create(Parking parkingCreate) {
		parkingCreate.setId(getUUID());
		parkingCreate.setEntryData(LocalDateTime.now());
		repository.save(parkingCreate);
		return parkingCreate;
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);

	}

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

	public Parking checkOut(String id) {
		// get the parking and update its exitDate

		return null;
	}

}
