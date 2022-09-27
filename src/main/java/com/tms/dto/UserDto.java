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
    private boolean isActive;

    public void setUsername(String username) {
        this.username = username.toLowerCase();
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public void setRoleAsUser() {
        setRoles(Collections.singleton(RoleEnum.USER.role));
    }

    public void setRoleAsAdmin() {
        setRoles(Collections.singleton(RoleEnum.ADMIN.role));
    }
}
