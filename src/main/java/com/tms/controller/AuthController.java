package com.tms.controller;

import com.tms.dto.UserDto;
import com.tms.dto.details.UserDetailsImpl;
import com.tms.security.JwtResponse;
import com.tms.service.AuthService;
import com.tms.service.UserService;
import com.tms.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("auth")
@RestController
public class AuthController {

    private final AuthService authService; /* TODO: remove later */
    private final UserService userService;

    private final AuthenticationManager authManager;
    private final JwtUtils jwtUtils;

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto register(@RequestBody UserDto user) {
        user.setRoleAsUser();
        user.setActive(false);
        return userService.register(user);
    }

    @PostMapping("login")
    public ResponseEntity<JwtResponse> login(@RequestBody UserDto user) {

        String username = user.getUsername().toLowerCase();
        String password = user.getPassword();
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.accepted().body(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toSet())));
    }

//    @PostMapping("logout")
//    public UserDto logout() {
//        return null;
//    }
}
