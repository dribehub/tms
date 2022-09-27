package com.tms.controller;

import com.tms.dto.FlightDto;
import com.tms.exception.request.IdNotFoundException;
import com.tms.exception.request.NullRequestBodyException;
import com.tms.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/flights")
@RestController
public class FlightController {

    private final FlightService service;

    @GetMapping("getAll")
    public List<FlightDto> getAll() {
        return service.getAll();
    }

    @GetMapping("getById/{id}")
    public FlightDto getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public FlightDto create(@RequestBody FlightDto flight) {
        return service.create(flight);
    }

    @PutMapping("update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public FlightDto update(@RequestBody FlightDto flight) {
        if (flight == null)
            throw new NullRequestBodyException();
        if (flight.getId() == null)
            throw new IdNotFoundException();
        return service.update(flight);
    }

    @DeleteMapping("deleteById/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public FlightDto deleteById(@PathVariable Integer id) {
        return service.deleteById(id);
    }
}
