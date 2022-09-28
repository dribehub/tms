package com.tms.service;

import com.tms.dto.TripDto;

import java.util.List;

public interface TripService {

    List<TripDto> getAll();

    TripDto getById(Integer id);

    List<TripDto> getByUserCreatedId(Integer userId);

    TripDto create(TripDto trip);

    TripDto update(Integer id, TripDto trip);

    TripDto sendApprovalById(Integer id);

    TripDto approveById(Integer id);

    TripDto deleteById(Integer id);
}
