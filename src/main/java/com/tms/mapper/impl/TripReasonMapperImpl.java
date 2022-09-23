package com.tms.mapper.impl;

import com.tms.dto.TripReasonDto;
import com.tms.entity.TripReason;
import com.tms.mapper.TripReasonMapper;

import org.springframework.stereotype.Component;

@Component
public class TripReasonMapperImpl implements TripReasonMapper {

    @Override
    public TripReason toEntity(TripReasonDto dto) {
        if (dto == null) return null;
        TripReason entity = new TripReason();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    @Override
    public TripReasonDto toDto(TripReason entity) {
        if (entity == null) return null;
        TripReasonDto dto = new TripReasonDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
