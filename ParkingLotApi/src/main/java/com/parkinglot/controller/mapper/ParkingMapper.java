package com.parkinglot.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.parkinglot.config.LombokBuilderNameTransformer;
import com.parkinglot.config.LombokBuilderNamingConvention;
import com.parkinglot.controller.dto.ParkingDTO;
import com.parkinglot.model.Parking;

@Component
public class ParkingMapper {
	
	public static final ModelMapper MODEL_MAPPER = new ModelMapper();
	
	public ParkingMapper() {
		MODEL_MAPPER.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.STRICT)
        .setDestinationNamingConvention(LombokBuilderNamingConvention.INSTANCE)
        .setDestinationNameTransformer(LombokBuilderNameTransformer.INSTANCE);
	}
	
	public ParkingDTO parkingDTO(Parking parking) {
		return 	MODEL_MAPPER.map(parking, ParkingDTO.ParkingDTOBuilder.class).build();
	}
	
	
	public List<ParkingDTO> toParkingDTOList(List<Parking> parkingList) {
		return parkingList.stream().map(this::parkingDTO).collect(Collectors.toList());
	}

}
