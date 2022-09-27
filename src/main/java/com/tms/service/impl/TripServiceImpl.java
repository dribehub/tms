package com.tms.service.impl;

import com.tms.dto.TripDto;
import com.tms.entity.Trip;
import com.tms.entity.TripStatus;
import com.tms.enums.TripStatusEnum;
import com.tms.exception.db.EntityNotFoundException;
import com.tms.exception.validation.trip.InvalidIntervalException;
import com.tms.exception.validation.trip.InvalidItineraryException;
import com.tms.mapper.TripMapper;
import com.tms.repository.TripRepository;
import com.tms.repository.TripStatusRepository;
import com.tms.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TripServiceImpl implements TripService {

    private final TripRepository repository;
    private final TripStatusRepository statusRepository;
    private final TripMapper mapper;

    @Override
    public List<TripDto> getAll() {
        return mapper.toDtos(repository.findAll());
    }

    @Override
    public TripDto getById(Integer id) {
         return mapper.toDto(repository.findById(id).orElseThrow(
                 () -> new EntityNotFoundException(Trip.class, id)));
    }

    @Override
    public TripDto create(TripDto trip) {
        validate(trip);
        trip.setStatus(getStatus(TripStatusEnum.CREATED));
        return mapper.toDto(repository.save(mapper.toEntity(trip)));
    }

    private void validate(TripDto trip) {
        if (trip.getFrom().equals(trip.getTo()))
            throw new InvalidItineraryException();
        if (trip.getDeparture().after(trip.getArrival()))
            throw new InvalidIntervalException();
    }

    @Override
    public TripDto update(TripDto trip) {
        trip.setStatus(getStatus(TripStatusEnum.WAITING_FOR_APPROVAL));
        return mapper.toDto(repository.save(mapper.toEntity(trip)));
    }

    @Override
    public TripDto sendApproval(TripDto trip) {
        trip.setStatus(getStatus(TripStatusEnum.WAITING_FOR_APPROVAL));
        return mapper.toDto(repository.save(mapper.toEntity(trip)));
    }

    @Override
    public TripDto approve(TripDto trip) {
        trip.setStatus(getStatus(TripStatusEnum.APPROVED));
        return mapper.toDto(repository.save(mapper.toEntity(trip)));
    }

    @Override
    public TripDto deleteById(Integer id) {
        Trip deleted = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(Trip.class, id));
        repository.deleteById(id);
        return mapper.toDto(deleted);
    }

    private TripStatus getStatus(TripStatusEnum status) {
        return statusRepository.findByName(status.name()).orElse(null);
    }
}
