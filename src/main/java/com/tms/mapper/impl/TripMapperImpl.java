package com.tms.mapper.impl;

import com.tms.dto.TripDto;
import com.tms.entity.Trip;
import com.tms.mapper.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TripMapperImpl implements TripMapper {

    private final TripReasonMapper reasonMapper;
    private final CountryMapper countryMapper;
    private final UserMapper userMapper;
    private final TripStatusMapper statusMapper;

    @Override
    public Trip toEntity(TripDto dto) {
        if (dto == null) return null;
        Trip entity = new Trip();
        entity.setId(dto.getId());
        entity.setReason(reasonMapper.toEntity(dto.getReason()));
        entity.setDescription(dto.getDescription());
        entity.setFrom(countryMapper.toEntity(dto.getFrom()));
        entity.setTo(countryMapper.toEntity(dto.getTo()));
        entity.setDeparture(dto.getDeparture());
        entity.setArrival(dto.getArrival());
        entity.setCreatedBy(userMapper.toEntity(dto.getCreatedBy()));
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setStatus(statusMapper.toEntity(dto.getStatus()));
        return entity;
    }

    @Override
    public TripDto toDto(Trip entity) {
        if (entity == null) return null;
        TripDto dto = new TripDto();
        dto.setId(entity.getId());
        dto.setReason(reasonMapper.toDto(entity.getReason()));
        dto.setDescription(entity.getDescription());
        dto.setFrom(countryMapper.toDto(entity.getFrom()));
        dto.setTo(countryMapper.toDto(entity.getTo()));
        dto.setDeparture(entity.getDeparture());
        dto.setArrival(entity.getArrival());
        dto.setCreatedBy(userMapper.toDto(entity.getCreatedBy()));
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setStatus(statusMapper.toDto(entity.getStatus()));
        return dto;
    }
}
