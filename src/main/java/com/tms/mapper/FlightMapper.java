package com.tms.mapper;

import com.tms.dto.FlightDto;
import com.tms.entity.Flight;

import java.util.List;

public interface FlightMapper {

    Flight toEntity(FlightDto dto);

    List<Flight> toEntities(List<FlightDto> dtos);

    FlightDto toDto(Flight entity);

    List<FlightDto> toDtos(List<Flight> entities);
}
