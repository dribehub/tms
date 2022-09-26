package com.tms.controller;

import com.tms.dto.UserDto;
import com.tms.enums.Role;
import com.tms.security.JwtResponse;
import com.tms.security.UserDetailsImpl;
import com.tms.service.AuthService;
import com.tms.service.UserService;
import com.tms.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("auth")
@RestController
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    private final AuthenticationManager authManager;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder encoder;

    @PostMapping("register")
    public UserDto register(@RequestBody UserDto user) {
        userService.validateNewUser(user);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setUserRoles(Collections.singleton(Role.USER.value));
        return userService.register(user);
    }

    @PostMapping("login")
    public ResponseEntity<JwtResponse> login(@RequestParam String username,
                                             @RequestParam String password) {

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toSet())));
    }

    @PostMapping("logout")
    public UserDto logout() {
        return null;
    }
}
