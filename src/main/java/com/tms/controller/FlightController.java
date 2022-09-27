package com.tms.controller;

import com.tms.dto.FlightDto;
import com.tms.exception.request.IdNotFoundException;
import com.tms.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/flights")
@RestController
public class FlightController {

    private final FlightService service;

    @GetMapping("list")
    public ResponseEntity<List<FlightDto>> getAll() {
        List<FlightDto> body = service.getAll();
        return ResponseEntity.ok(body);
    }

    @GetMapping("{id}")
    public ResponseEntity<FlightDto> getById(@PathVariable Integer id) {
        FlightDto body = service.getById(id);
        return ResponseEntity.ok(body);
    }

    @PostMapping
    public ResponseEntity<FlightDto> create(@RequestBody FlightDto flight) {
        FlightDto body = service.create(flight);
        return ResponseEntity.ok(body);
    }

    @PutMapping
    public ResponseEntity<FlightDto> update(@RequestBody FlightDto flight) {
        if (flight.getId() == null)
            throw new IdNotFoundException();
        FlightDto body = service.update(flight);
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<FlightDto> deleteById(@PathVariable Integer id) {
        FlightDto body = service.deleteById(id);
        return ResponseEntity.ok(body);
    }
}
