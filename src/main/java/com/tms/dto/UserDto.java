package com.tms.dto;

import lombok.*;
import java.sql.Timestamp;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class UserDto {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private Timestamp createdAt;
    private Set<UserRoleDto> userRoles;

    public void setUsername(String username) {
        this.username = username.toLowerCase();
    }
}
