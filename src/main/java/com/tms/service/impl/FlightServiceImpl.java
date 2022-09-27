package com.tms.service.impl;

import com.tms.dto.FlightDto;
import com.tms.entity.Flight;
import com.tms.exception.db.EntityNotFoundException;
import com.tms.mapper.FlightMapper;
import com.tms.repository.FlightRepository;
import com.tms.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository repository;
    private final FlightMapper mapper;

    private Flight safeFindById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(Flight.class, id));
    }

    @Override
    public List<FlightDto> getAll() {
        return mapper.toDtos(repository.findAll());
    }

    @Override
    public FlightDto getById(Integer id) {
        return mapper.toDto(safeFindById(id));
    }

    @Override
    public FlightDto create(FlightDto flight) {
        if (!flight.getTrip().isApproved())
            throw new RequestRejectedException("This trip is not yet approved");
        return mapper.toDto(repository.save(mapper.toEntity(flight)));
    }

    @Override
    public FlightDto update(FlightDto flight) {
        safeFindById(flight.getId());
        if (!flight.getTrip().isApproved())
            throw new RequestRejectedException("This trip is not yet approved");
        return mapper.toDto(repository.save(mapper.toEntity(flight)));
    }

    @Override
    public FlightDto deleteById(Integer id) {
        Flight deleted = safeFindById(id);
        repository.deleteById(id);
        return mapper.toDto(deleted);
    }
}
