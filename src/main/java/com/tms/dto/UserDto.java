package com.tms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tms.entity.UserRole;
import com.tms.enums.Role;
import lombok.*;

import java.util.Collections;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
@JsonIgnoreProperties(value = {"password"}, allowSetters = true)
public class UserDto {

    private Integer id;

    private String username;

    private String email;

    private String password;

    private Set<UserRole> roles;

    public void setUsername(String username) {
        this.username = username.toLowerCase();
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public void setRoleAsUser() {
        setRoles(Collections.singleton(Role.USER.role));
    }

    public void setRoleAsAdmin() {
        setRoles(Collections.singleton(Role.ADMIN.role));
    }
}
