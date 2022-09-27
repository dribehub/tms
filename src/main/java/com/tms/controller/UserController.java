package com.tms.controller;

import com.tms.dto.UserDto;
import com.tms.exception.request.IdNotFoundException;
import com.tms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController {

    private final UserService service;

    @GetMapping("list")
    public ResponseEntity<List<UserDto>> getAll(
            @RequestParam(required = false) Boolean isActive,
            @RequestParam(required = false) Boolean isApproved) {
        List<UserDto> body = service.getAll(isActive, isApproved);
        return ResponseEntity.ok(body);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer id) {
        UserDto body = service.getById(id);
        return ResponseEntity.ok(body);
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto user) {
        user.setIsActive(true);
        user.setIsApproved(true);
        UserDto body = service.register(user);
        return ResponseEntity.ok(body);
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto user) {
        if (user.getId() == null)
            throw new IdNotFoundException();
        UserDto body = service.update(user);
        return ResponseEntity.ok(body);
    }

    @PutMapping("approve/{id}")
    public ResponseEntity<UserDto> approveById(@PathVariable Integer id) {
        UserDto body = service.setApprovedById(id, true);
        return ResponseEntity.ok(body);
    }

    @PutMapping("reject/{id}")
    public ResponseEntity<UserDto> rejectById(@PathVariable Integer id) {
        UserDto body = service.setApprovedById(id, false);
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<UserDto> deleteById(@PathVariable Integer id) {
        UserDto body = service.deleteById(id);
        return ResponseEntity.ok(body);
    }
}
