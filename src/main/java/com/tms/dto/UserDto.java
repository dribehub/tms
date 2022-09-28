package com.tms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tms.entity.UserRole;
import com.tms.enums.RoleEnum;
import com.tms.exception.validation.user.InvalidEmailFormatException;
import com.tms.exception.validation.user.InvalidUsernameException;
import com.tms.util.PatternUtils;
import lombok.*;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
@JsonIgnoreProperties(value = {"password", "roles"}, allowSetters = true)
public class UserDto {

    private Integer id;

    private String username;

    private String email;

    private String password;

    private Set<UserRole> roles;

    @JsonIgnore
    private Timestamp createdAt;

    @JsonIgnore
    private Timestamp updatedAt;

    private Boolean isApproved;

    @JsonIgnore
    private Boolean isActive;

    public void setUsername(String username) {
        String validated = username.toLowerCase();
        if (!PatternUtils.isUsername(username))
            throw new InvalidUsernameException(username);
        this.username = validated;
    }

    public void setEmail(String email) {
        String validated = email.toLowerCase();
        if (!PatternUtils.isEmail(validated))
            throw new InvalidEmailFormatException(validated);
        this.email = validated;
    }

    public void addRole(RoleEnum roleEnum) {
        roles.add(roleEnum.userRole);
    }

    public void setRole(RoleEnum roleEnum) {
        roles = Collections.singleton(roleEnum.userRole);
    }

    public void setRoleAsUser() {
        setRole(RoleEnum.USER);
    }

    public void setRoleAsAdmin() {
        setRole(RoleEnum.ADMIN);
    }
}
