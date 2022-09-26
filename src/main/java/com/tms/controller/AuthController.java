package com.tms.controller;

import com.tms.dto.UserDto;
import com.tms.service.AuthService;
import com.tms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/auth")
@RestController
public class AuthController {

    private final AuthService service;
    private final UserService userService;

    @PostMapping("register")
    public UserDto register(@RequestBody UserDto user) {
        return userService.register(user);
    }

    @PostMapping("login")
    public UserDto login(@RequestBody UserDto user) {
        return null;
    }

    @PostMapping("logout")
    public UserDto logout() {
        return null;
    }
}
