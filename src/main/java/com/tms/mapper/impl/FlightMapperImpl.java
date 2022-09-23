package com.tms.mapper.impl;

import com.tms.dto.FlightDto;
import com.tms.entity.Flight;
import com.tms.mapper.FlightMapper;
import com.tms.mapper.TripMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FlightMapperImpl implements FlightMapper {

    private final TripMapper tripMapper;

    @Override
    public Flight toEntity(FlightDto dto) {
        if (dto == null) return null;
        Flight entity = new Flight();
        entity.setId(dto.getId());
        entity.setTrip(tripMapper.toEntity(dto.getTrip()));
        return entity;
    }

    @Override
    public FlightDto toDto(Flight entity) {
        if (entity == null) return null;
        FlightDto dto = new FlightDto();
        dto.setId(entity.getId());
        dto.setTrip(tripMapper.toDto(entity.getTrip()));
        return dto;
    }
}
