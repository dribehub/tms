package com.tms.mapper.impl;

import com.tms.dto.TripStatusDto;
import com.tms.entity.TripStatus;
import com.tms.mapper.TripStatusMapper;

import org.springframework.stereotype.Component;

@Component
public class TripStatusMapperImpl implements TripStatusMapper {

    @Override
    public TripStatus toEntity(TripStatusDto dto) {
        if (dto == null) return null;
        TripStatus entity = new TripStatus();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    @Override
    public TripStatusDto toDto(TripStatus entity) {
        if (entity == null) return null;
        TripStatusDto dto = new TripStatusDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
