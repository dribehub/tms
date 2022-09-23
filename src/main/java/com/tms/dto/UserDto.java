package com.tms.dto;

import lombok.*;
import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class UserDto {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private Timestamp createdAt;
    private List<UserRoleDto> userRoles;
}
