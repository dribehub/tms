package com.tms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tms.entity.UserRole;
import com.tms.enums.RoleEnum;
import lombok.*;

import java.sql.Timestamp;
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

    @JsonIgnore
    private Set<UserRole> roles;

    @JsonIgnore
    private Timestamp createdAt;

    @JsonIgnore
    private Timestamp updatedAt;

    private boolean isApproved;

    @JsonIgnore
    private boolean isActive;

    public void setUsername(String username) {
        this.username = username.toLowerCase();
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public void addRole(RoleEnum role) {
        roles.add(role.role);
    }

    public void setRole(RoleEnum role) {
        roles = Collections.singleton(role.role);
    }

    public void setRoleAsUser() {
        setRole(RoleEnum.USER);
    }

    public void setRoleAsAdmin() {
        setRole(RoleEnum.ADMIN);
    }
}
