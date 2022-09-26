package com.tms.security;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class JwtResponse {

    private String type = "Basic";
    private String token;
    private Integer id;
    private String username;
    private String email;
    private Set<String> roles;

    public JwtResponse(String token, Integer id, String username, String email, Set<String> roles) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
