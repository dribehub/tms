package com.tms.service.impl;

import com.tms.entity.Country;
import com.tms.exception.db.EntityNotFoundException;
import com.tms.repository.CountryRepository;
import com.tms.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/* TODO to be deleted afterwards or be kept for admin CRUD */
@RequiredArgsConstructor
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;

    @Override
    public List<Country> getAll() {
        return repository.findAll();
    }

    @Override
    public Country getById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(Country.class, id));
    }

    @Override
    public Country create(Country country) {
        return repository.save(country);
    }

    @Override
    public Country update(Country country) {
        repository.findById(country.getId()).orElseThrow(
                () -> new EntityNotFoundException(Country.class, country.getId()));
        return repository.save(country);
    }

    @Override
    public Country deleteById(Integer id) {
        Country deleted = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(Country.class, id));
        repository.deleteById(id);
        return deleted;
    }
}
