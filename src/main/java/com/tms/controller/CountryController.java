package com.tms.controller;

import com.tms.entity.Country;
import com.tms.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/countries")
@RestController
public class CountryController {

    private final CountryService service;

    @GetMapping("list")
    public ResponseEntity<List<Country>> getAll() {
        List<Country> body = service.getAll();
        return ResponseEntity.ok(body);
    }

    @PostMapping
    public ResponseEntity<Country> create(@RequestBody Country country) {
        Country body = service.create(country);
        return ResponseEntity.ok(body);
    }

    @PostMapping("massUpload")
    public ResponseEntity<List<Country>> create(@RequestBody List<Country> countries) {
        List<Country> body = service.create(countries);
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Country> deleteById(@PathVariable Integer id) {
        Country body = service.deleteById(id);
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("all")
    public void deleteAll() {
        service.deleteAll();
    }
}
