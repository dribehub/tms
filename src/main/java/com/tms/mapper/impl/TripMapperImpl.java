package com.tms.mapper.impl;

import com.tms.dto.TripDto;
import com.tms.entity.Trip;
import com.tms.mapper.TripMapper;
import com.tms.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class TripMapperImpl implements TripMapper {

    private final UserMapper userMapper;

    @Override
    public Trip toEntity(TripDto dto) {
        return dto == null ? null : new Trip(
                dto.getId(),
                dto.getReason(),
                dto.getDescription(),
                dto.getFrom(),
                dto.getTo(),
                dto.getDeparture(),
                dto.getArrival(),
                userMapper.toEntity(dto.getCreatedBy()),
                dto.getCreatedAt(),
                dto.getStatus()
        );
    }

    @Override
    public List<Trip> toEntities(List<TripDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public TripDto toDto(Trip entity) {
        return entity == null ? null : new TripDto(
                entity.getId(),
                entity.getReason(),
                entity.getDescription(),
                entity.getFrom(),
                entity.getTo(),
                entity.getDeparture(),
                entity.getArrival(),
                userMapper.toDto(entity.getCreatedBy()),
                entity.getCreatedAt(),
                entity.getStatus()
        );
    }

    @Override
    public List<TripDto> toDtos(List<Trip> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
