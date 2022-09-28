package com.tms.service.impl;

import com.tms.entity.Country;
import com.tms.exception.db.EntityNotFoundException;
import com.tms.repository.CountryRepository;
import com.tms.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;

    private Country safeFindById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(Country.class, id));
    }

    @Override
    public List<Country> getAll() {
        return repository.findAll();
    }

    @Override
    public Country getById(Integer id) {
        return safeFindById(id);
    }

    @Override
    public Country create(Country country) {
        return repository.save(country);
    }

    @Override
    public List<Country> create(List<Country> countries) {
        return repository.saveAll(countries);
    }

    @Override
    public Country update(Country country) {
        safeFindById(country.getId());
        return repository.save(country);
    }

    @Override
    public Country deleteById(Integer id) {
        Country deleted = safeFindById(id);
        repository.deleteById(id);
        return deleted;
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
