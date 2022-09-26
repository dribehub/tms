package com.tms.dto;

import com.tms.entity.UserRole;
import lombok.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class UserDto {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private Set<UserRole> userRoles;

    public void setUsername(String username) {
        this.username = username.toLowerCase();
    }
}
