package com.tms.mapper;

import com.tms.dto.TripReasonDto;
import com.tms.entity.TripReason;

public interface TripReasonMapper {

    TripReason toEntity(TripReasonDto dto);
    TripReasonDto toDto(TripReason entity);
}
