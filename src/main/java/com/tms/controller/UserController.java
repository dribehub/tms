package com.tms.controller;

import com.tms.dto.UserDto;
import com.tms.exception.request.IdNotFoundException;
import com.tms.exception.request.NullRequestBodyException;
import com.tms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
@RestController
public class UserController {

    private final UserService service;

    @GetMapping("getAll")
    public List<UserDto> getAll() {
        return service.getActive();
    }

    @GetMapping("getApproved")
    public List<UserDto> getApproved() {
        return service.getApproved();
    }

    @GetMapping("getNotApproved")
    public List<UserDto> getNotApproved() {
        return service.getNotApproved();
    }

    @GetMapping("getById/{id}")
    public UserDto getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody UserDto user) {
        user.setActive(true);
        user.setApproved(true);
        return service.register(user);
    }

    @PutMapping("update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserDto update(@RequestBody UserDto user) {
        if (user == null)
            throw new NullRequestBodyException();
        if (user.getId() == null)
            throw new IdNotFoundException();
        return service.update(user);
    }

    @PutMapping("approve/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserDto approveById(@PathVariable Integer id) {
        return service.setApprovedById(id, true);
    }

    @PutMapping("reject/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserDto rejectById(@PathVariable Integer id) {
        return service.setApprovedById(id, false);
    }

    @DeleteMapping("deleteById/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserDto deleteById(@PathVariable Integer id) {
        return service.deleteById(id);
    }
}
