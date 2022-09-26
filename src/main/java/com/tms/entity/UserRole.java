package com.tms.entity;

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

    @Override
    public String getAuthority() {
        return name;
    }
}
