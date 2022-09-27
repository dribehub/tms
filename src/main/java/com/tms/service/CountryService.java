package com.tms.service;

import com.tms.entity.Country;

import java.util.List;

public interface CountryService {

    List<Country> getAll();

    Country getById(Integer id);

    Country create(Country country);

    Country update(Country country);

    Country deleteById(Integer id);
}
