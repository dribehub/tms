package com.tms.mapper.impl;

import com.tms.dto.CountryDto;
import com.tms.entity.Country;
import com.tms.mapper.CountryMapper;

import org.springframework.stereotype.Component;

@Component
public class CountryMapperImpl implements CountryMapper {

    @Override
    public Country toEntity(CountryDto dto) {
        if (dto == null) return null;
        Country entity = new Country();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    @Override
    public CountryDto toDto(Country entity) {
        if (entity == null) return null;
        CountryDto dto = new CountryDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
