package com.tms.entity;

import com.tms.enums.RoleEnum;
import com.tms.exception.db.EntityNotFoundException;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
@Entity @Table(name = "role")
public class UserRole implements GrantedAuthority {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public UserRole(String name) {
        UserRole role = RoleEnum.getRoleByName(name)
                .orElseThrow(() -> EntityNotFoundException
                        .name(UserRole.class, name));
        this.id = role.id;
        this.name = role.name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
