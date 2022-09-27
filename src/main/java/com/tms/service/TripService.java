package com.tms.service;

import com.tms.dto.TripDto;

import java.util.List;

public interface TripService {

    List<TripDto> getAll();

    TripDto getById(Integer id);

    TripDto create(TripDto trip);

    TripDto sendApproval(TripDto trip);

    TripDto approve(TripDto trip);

    TripDto update(TripDto trip);

    TripDto deleteById(Integer id);
}
