package com.tms.mapper.impl;

import com.tms.dto.TripDto;
import com.tms.entity.Trip;
import com.tms.mapper.TripMapper;
import com.tms.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TripMapperImpl implements TripMapper {

    private final UserMapper userMapper;

    @Override
    public Trip toEntity(TripDto dto) {
        if (dto == null) return null;
        Trip entity = new Trip();
        entity.setId(dto.getId());
        entity.setReason(dto.getReason());
        entity.setDescription(dto.getDescription());
        entity.setFrom(dto.getFrom());
        entity.setTo(dto.getTo());
        entity.setDeparture(dto.getDeparture());
        entity.setArrival(dto.getArrival());
        entity.setCreatedBy(userMapper.toEntity(dto.getCreatedBy()));
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    @Override
    public TripDto toDto(Trip entity) {
        if (entity == null) return null;
        TripDto dto = new TripDto();
        dto.setId(entity.getId());
        dto.setReason(entity.getReason());
        dto.setDescription(entity.getDescription());
        dto.setFrom(entity.getFrom());
        dto.setTo(entity.getTo());
        dto.setDeparture(entity.getDeparture());
        dto.setArrival(entity.getArrival());
        dto.setCreatedBy(userMapper.toDto(entity.getCreatedBy()));
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
