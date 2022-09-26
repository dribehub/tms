package com.tms.controller;

import com.tms.dto.UserDto;
import com.tms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
@RestController
public class UserController {

    private final UserService service;

    @GetMapping("all")
    public List<UserDto> getAll() {
        return service.getAll();
    }
}
