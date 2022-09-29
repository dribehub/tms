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

@RequiredArgsConstructor
@Service
public class TripServiceImpl implements TripService {

    private final TripRepository repository;
    private final TripStatusRepository statusRepository;
    private final TripMapper mapper;

    private Trip safeFindById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(Trip.class, id));
    }

    @Override
    public List<TripDto> getAll() {
        return mapper.toDtos(repository.findAll());
    }

    @Override
    public TripDto getById(Integer id) {
        return mapper.toDto(safeFindById(id));
    }

    @Override
    public List<TripDto> getByUserCreatedId(Integer userId) {
        return mapper.toDtos(repository.findByUserCreatedId(userId));
    }

    @Override
    public TripDto create(TripDto trip) {
        trip.setStatus(getStatus(TripStatusEnum.CREATED));
//        trip.setCreatedBy();
        return mapper.toDto(repository.save(mapper.toEntity(trip)));
    }

    @Override
    public TripDto update(Integer id, TripDto updated) {
        Trip existing = safeFindById(id);
        if (updated.getReason() != null)
            existing.setReason(updated.getReason());
        if (updated.getDescription() != null)
            existing.setDescription(updated.getDescription());
        if (updated.getFrom() != null)
            existing.setFrom(updated.getFrom());
        if (updated.getTo() != null)
            existing.setTo(updated.getTo());
        if (updated.getDeparture() != null)
            existing.setDeparture(updated.getDeparture());
        if (updated.getArrival() != null)
            existing.setArrival(updated.getArrival());
        existing.setStatus(updated.getStatus() != null
                ? updated.getStatus() // admin
                : getStatus(TripStatusEnum.WAITING_FOR_APPROVAL)); // user
        return mapper.toDto(repository.save(existing));
    }

    @Override
    public TripDto sendApprovalById(Integer id) {
        Trip sentApproval = safeFindById(id);
        sentApproval.setStatus(getStatus(TripStatusEnum.WAITING_FOR_APPROVAL));
        // TODO: notify admins
        return mapper.toDto(repository.save(sentApproval));
    }

    @Override
    public TripDto approveById(Integer id) {
        Trip approved = safeFindById(id);
        approved.setStatus(getStatus(TripStatusEnum.APPROVED));
        return mapper.toDto(repository.save(approved));
    }

    @Override
    public TripDto deleteById(Integer id) {
        Trip deleted = safeFindById(id);
        repository.deleteById(id);
        return mapper.toDto(deleted);
    }

    private TripStatus getStatus(TripStatusEnum status) {
        return statusRepository.findByName(status.name()).orElse(null);
    }
}
