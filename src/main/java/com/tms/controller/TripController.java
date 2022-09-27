package com.tms.controller;

import com.tms.dto.TripDto;
import com.tms.exception.request.IdNotFoundException;
import com.tms.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/trips")
@RestController
public class TripController {

    private final TripService service;

    @GetMapping("list")
    public ResponseEntity<List<TripDto>> getAll() {
        List<TripDto> body = service.getAll();
        return ResponseEntity.ok(body);
    }

    @GetMapping("{id}")
    public ResponseEntity<TripDto> getById(@PathVariable Integer id) {
        TripDto body = service.getById(id);
        return ResponseEntity.ok(body);
    }

    @PostMapping
    public ResponseEntity<TripDto> create(@RequestBody TripDto trip) {
        TripDto body = service.create(trip);
        return ResponseEntity.ok(body);
    }

    @PutMapping
    public ResponseEntity<TripDto> update(@RequestBody TripDto trip) {
        if (trip.getId() == null)
            throw new IdNotFoundException();
        TripDto body = service.update(trip);
        return ResponseEntity.ok(body);
    }

    @PutMapping("sendApproval/{id}")
    public ResponseEntity<TripDto> sendApprovalById(@PathVariable Integer id) {
        TripDto body = service.sendApprovalById(id);
        return ResponseEntity.ok(body);
    }

    @PutMapping("approve/{id}")
    public ResponseEntity<TripDto> approveById(@PathVariable Integer id) {
        TripDto body = service.approveById(id);
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TripDto> deleteById(@PathVariable Integer id) {
        TripDto body = service.deleteById(id);
        return ResponseEntity.ok(body);
    }
}
