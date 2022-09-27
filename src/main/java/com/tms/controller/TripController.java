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

    @GetMapping("getAll")
    public List<TripDto> getAll() {
        return service.getAll();
    }

    @GetMapping("getById/{id}")
    public TripDto getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping("create") // user
    @ResponseStatus(HttpStatus.CREATED)
    public TripDto create(@RequestBody TripDto trip) {
        return service.create(trip);
    }

    @PutMapping("update") // admin, user
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TripDto update(@RequestBody TripDto trip) {
        if (trip == null)
            throw new NullRequestBodyException();
        if (trip.getId() == null)
            throw new IdNotFoundException();
        return service.update(trip);
    }

    @PutMapping("sendApprovalById/{id}") // user
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TripDto sendApprovalById(@PathVariable Integer id) {
        return service.sendApprovalById(id);
    }

    @PutMapping("approveById/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TripDto approveById(@PathVariable Integer id) {
        return service.approveById(id);
    }

    @DeleteMapping("deleteById/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TripDto deleteById(@PathVariable Integer id) {
        return service.deleteById(id);
    }
}
