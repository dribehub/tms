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
        return service.getAll();
    }

    @GetMapping("getActive")
    public List<UserDto> getActive() {
        return service.getActive();
    }

    @GetMapping("getNotActive")
    public List<UserDto> getNotActive() {
        return service.getNotActive();
    }

    @GetMapping("getById")
    public UserDto getById(@RequestParam Integer id) {
        return service.getById(id);
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody UserDto user) {
        user.setActive(true);
        return service.register(user);
    }

    @PutMapping("update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserDto update(@RequestBody UserDto user) {
        if (user == null) throw new NullRequestBodyException();
        if (user.getId() == null) throw new IdNotFoundException();
        return service.update(user);
    }

    @PutMapping("activate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserDto activateById(@RequestParam Integer id) {
        return service.activateById(id);
    }

    @DeleteMapping("deleteById")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserDto deleteById(@RequestParam Integer id) {
        return service.deleteById(id);
    }
}
