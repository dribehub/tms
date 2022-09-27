package com.tms.mapper.impl;

import com.tms.dto.FlightDto;
import com.tms.entity.Flight;
import com.tms.mapper.FlightMapper;
import com.tms.mapper.TripMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class FlightMapperImpl implements FlightMapper {

    private final TripMapper tripMapper;

    @Override
    public Flight toEntity(FlightDto dto) {
        return dto == null ? null : new Flight(
                dto.getId(),
                tripMapper.toEntity(dto.getTrip())
        );
    }

    @Override
    public List<Flight> toEntities(List<FlightDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public FlightDto toDto(Flight entity) {
        return entity == null ? null : new FlightDto(
                entity.getId(),
                tripMapper.toDto(entity.getTrip())
        );
    }

    @Override
    public List<FlightDto> toDtos(List<Flight> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
