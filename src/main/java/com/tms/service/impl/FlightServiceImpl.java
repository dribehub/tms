package com.tms.service.impl;

import com.tms.dto.FlightDto;
import com.tms.entity.Flight;
import com.tms.entity.TripStatus;
import com.tms.enums.TripStatusEnum;
import com.tms.exception.db.EntityNotFoundException;
import com.tms.mapper.FlightMapper;
import com.tms.repository.FlightRepository;
import com.tms.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository repository;
    private final FlightMapper mapper;

    @Override
    public List<FlightDto> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FlightDto getById(Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(Flight.class, id)));
    }

    @Override
    public FlightDto create(FlightDto flight) {
        if (!flight.getTrip().isApproved())
            throw new RequestRejectedException("This trip is not yet approved");
        return mapper.toDto(repository.save(mapper.toEntity(flight)));
    }

    @Override
    public FlightDto update(FlightDto flight) {
        repository.findById(flight.getId()).orElseThrow(
                () -> new EntityNotFoundException(Flight.class, flight.getId()));
        if (!flight.getTrip().isApproved())
            throw new RequestRejectedException("This trip is not yet approved");
        return mapper.toDto(repository.save(mapper.toEntity(flight)));
    }

    @Override
    public FlightDto deleteById(Integer id) {
        Flight deleted = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(Flight.class, id));
        repository.deleteById(id);
        return mapper.toDto(deleted);
    }
}
