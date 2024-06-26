package com.tms.controller;

import com.tms.dto.TripDto;
import com.tms.dto.UserDto;
import com.tms.exception.request.IdNotFoundException;
import com.tms.service.AuthService;
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
    private final AuthService authService;

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

    @GetMapping("userId/{userId}")
    public ResponseEntity<List<TripDto>> getByUserCreatedId(@PathVariable Integer userId) {
        List<TripDto> body = service.getByUserCreatedId(userId);
        return ResponseEntity.ok(body);
    }

    @PostMapping
    public ResponseEntity<TripDto> create(@RequestBody TripDto trip) {
        trip.setCreatedBy(authService.getPrinciple());
        TripDto body = service.create(trip);
        return ResponseEntity.ok(body);
    }

    @PutMapping("{id}")
    public ResponseEntity<TripDto> update(@PathVariable Integer id, @RequestBody TripDto trip) {
        TripDto body = service.update(id, trip);
        return ResponseEntity.ok(body);
    }

    @PutMapping("send/{id}")
    public ResponseEntity<TripDto> sendApprovalById(@PathVariable Integer id) {
        TripDto existing = service.getById(id);
        if (!existing.getCreatedBy().getId().equals(authService.getPrinciple().getId()))
            throw new RuntimeException();
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
