package com.tms.service.impl;

import com.tms.mapper.FlightMapper;
import com.tms.repository.FlightRepository;
import com.tms.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository repository;
    private final FlightMapper mapper;
}
