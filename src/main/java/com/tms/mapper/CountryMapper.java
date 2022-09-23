package com.tms.mapper;

import com.tms.dto.CountryDto;
import com.tms.entity.Country;

public interface CountryMapper {

    Country toEntity(CountryDto dto);
    CountryDto toDto(Country entity);
}
