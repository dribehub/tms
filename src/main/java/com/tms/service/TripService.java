package com.tms.service;

import com.tms.dto.TripDto;

import java.util.List;

public interface TripService {

    List<TripDto> getAll();

    TripDto getById(Integer id);

    TripDto create(TripDto trip);

    TripDto update(TripDto trip);

    TripDto sendApprovalById(Integer id);

    TripDto approveById(Integer id);

    TripDto deleteById(Integer id);
}
