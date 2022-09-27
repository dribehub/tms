package com.tms.controller;

import com.tms.dto.TripDto;
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

    @GetMapping("getById")
    public TripDto getById(@RequestParam Integer id) {
        return service.getById(id);
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public TripDto create(@RequestBody TripDto trip) {
        return service.create(trip);
    }
}
