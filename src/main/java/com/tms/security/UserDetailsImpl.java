package com.tms.security;

import com.tms.entity.UserRole;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UserDetailsImpl implements UserDetails {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private Timestamp createdAt;

    private boolean enabled = true;
    private Set<UserRole> authorities = new HashSet<>();

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }
}
