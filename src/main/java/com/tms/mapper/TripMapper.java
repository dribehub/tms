package com.tms.mapper;

import com.tms.dto.TripDto;
import com.tms.entity.Trip;

public interface TripMapper {

    Trip toEntity(TripDto dto);
    TripDto toDto(Trip entity);
}
