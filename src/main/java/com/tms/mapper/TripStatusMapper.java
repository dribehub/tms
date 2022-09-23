package com.tms.mapper;

import com.tms.dto.TripStatusDto;
import com.tms.entity.TripStatus;

public interface TripStatusMapper {

    TripStatus toEntity(TripStatusDto dto);
    TripStatusDto toDto(TripStatus entity);
}
