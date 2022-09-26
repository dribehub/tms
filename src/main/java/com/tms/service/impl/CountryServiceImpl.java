package com.tms.service.impl;

import com.tms.repository.CountryRepository;
import com.tms.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CountryServiceImpl implements CountryService {
    // to be deleted afterwards
    // or be kept for admin CRUD

    private final CountryRepository repository;
}
