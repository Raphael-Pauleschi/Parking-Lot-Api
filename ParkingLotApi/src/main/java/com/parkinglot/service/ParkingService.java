package com.parkinglot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.parkinglot.model.Parking;

@Service
public class ParkingService {
	private static Map<String, Parking> parkingMap = new HashMap();
	
	static {
		var id  = getUUID();
		//Parking parking = new Parking(id,"DMS-111","SC","Celta","black");
		Parking parking = Parking.builder()
				.id(id).state("SC").color("black")
				.model("Celta").license("DMS-111")
				.build();
		parkingMap.put(id, parking);
		id  = getUUID();
		Parking parking2 = Parking.builder()
				.id(id).state("SP").color("red")
				.model("VW GOL").license("WAS-1234")
				.build();
		parkingMap.put(id, parking2);
	}
	
	public List<Parking> findAll(){
		return parkingMap.values().stream().collect(Collectors.toList());
	}
	
	public Parking findById(String id) {
		return parkingMap.get(id);
	}

	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-","");
	}

}
