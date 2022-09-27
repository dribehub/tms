package com.tms.controller;

import com.tms.dto.TripDto;
import com.tms.exception.request.IdNotFoundException;
import com.tms.exception.request.NullRequestBodyException;
import com.tms.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/trips")
@RestController
public class TripController {

    private final TripService service;

    @GetMapping("getAll") // admin
    public List<TripDto> getAll() {
        return service.getAll();
    }

    @GetMapping("getById") // admin
    public TripDto getById(@RequestParam Integer id) {
        return service.getById(id);
    }

    @PostMapping("create") // user
    @ResponseStatus(HttpStatus.CREATED)
    public TripDto create(@RequestBody TripDto trip) {
        return service.create(trip);
    }

    @PutMapping("update") // admin, user (status changes to WAITING_FOR_APPROVAL
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TripDto update(@RequestBody TripDto trip) {
        if (trip == null) throw new NullRequestBodyException();
        if (trip.getId() == null) throw new IdNotFoundException();
        return service.update(trip);
    }

    @DeleteMapping("deleteById") // admin
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TripDto deleteById(@RequestParam Integer id) {
        return service.deleteById(id);
    }
}
