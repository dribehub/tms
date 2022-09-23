package com.tms.mapper;

import com.tms.dto.FlightDto;
import com.tms.entity.Flight;

public interface FlightMapper {

    Flight toEntity(FlightDto dto);
    FlightDto toDto(Flight entity);
}
