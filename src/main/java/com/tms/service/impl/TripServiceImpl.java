package com.tms.service.impl;

import com.tms.mapper.TripMapper;
import com.tms.repository.TripRepository;
import com.tms.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TripServiceImpl implements TripService {

    private final TripRepository repository;
    private final TripMapper mapper;
}
