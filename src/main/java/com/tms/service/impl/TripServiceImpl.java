package com.tms.service.impl;

import com.tms.dto.TripDto;
import com.tms.entity.Trip;
import com.tms.entity.TripStatus;
import com.tms.enums.TripStatusEnum;
import com.tms.exception.db.EntityNotFoundException;
import com.tms.mapper.TripMapper;
import com.tms.repository.TripRepository;
import com.tms.repository.TripStatusRepository;
import com.tms.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TripServiceImpl implements TripService {

    private final TripRepository repository;
    private final TripStatusRepository statusRepository;
    private final TripMapper mapper;

    @Override
    public List<TripDto> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TripDto getById(Integer id) {
         return mapper.toDto(repository.findById(id).orElseThrow(
                 () -> new EntityNotFoundException(Trip.class, id)));
    }

    @Override
    public TripDto create(TripDto trip) {
        trip.setStatus(getStatus(TripStatusEnum.CREATED));
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
    public TripDto update(TripDto trip) {
        trip.setStatus(getStatus(TripStatusEnum.WAITING_FOR_APPROVAL));
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
        return statusRepository
                .findByName(status.name())
                .orElse(null);
    }
}
