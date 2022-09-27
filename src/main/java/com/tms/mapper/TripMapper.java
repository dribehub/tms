package com.tms.mapper;

import com.tms.dto.TripDto;
import com.tms.entity.Trip;

import java.util.List;

public interface TripMapper {

    Trip toEntity(TripDto dto);

    List<Trip> toEntities(List<TripDto> dtos);

    TripDto toDto(Trip entity);

    List<TripDto> toDtos(List<Trip> entities);
}
