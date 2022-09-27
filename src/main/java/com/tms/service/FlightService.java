package com.tms.service;

import com.tms.dto.FlightDto;

import java.util.List;

public interface FlightService {
    
    List<FlightDto> getAll();

    FlightDto getById(Integer id);

    FlightDto create(FlightDto flight);

    FlightDto update(FlightDto flight);

    FlightDto deleteById(Integer id);
}
