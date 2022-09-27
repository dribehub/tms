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
@RequestMapping("auth")
@RestController
public class AuthController {

    private final AuthService authService; /* TODO: remove later */
    private final UserService userService;

    private final AuthenticationManager authManager;
    private final JwtUtils jwtUtils;

    @PostMapping("register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto user) {
        user.setRoleAsUser();
        user.setIsActive(true);
        user.setIsApproved(false);
        UserDto body = userService.register(user);
        return ResponseEntity.ok(body);
    }

    @PostMapping("login")
    public ResponseEntity<JwtResponse> login(@RequestBody UserDto user) {

        String username = user.getUsername().toLowerCase();
        String password = user.getPassword();
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        SecurityContextHolder.getContext().setAuthentication(auth);

        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();

        JwtResponse body = new JwtResponse(
                jwtUtils.generateJwtToken(auth),
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getSimpleAuthorities()
        );

        return ResponseEntity.accepted().body(body);
    }

    /* TODO: logout session */
//    @PostMapping("logout")
//    public UserDto logout() {
//        return null;
//    }
}
