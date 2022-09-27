package com.tms.service.impl;

import com.tms.dto.UserDto;
import com.tms.entity.User;
import com.tms.enums.RoleEnum;
import com.tms.mapper.UserMapper;
import com.tms.repository.UserRepository;
import com.tms.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/* TODO: consider deleting this service */
@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public UserDto getPrinciple() {
        String username = getAuthentication().getName();
        User loggedInUser = userRepository.findByUsername(username).orElse(null);
        return userMapper.toDto(loggedInUser);
    }

    @Override
    public Integer getPrincipleId() {
        return getPrinciple().getId();
    }

    @Override
    public boolean isPrincipleAdmin() {
        return isPrincipleOfRole(RoleEnum.ADMIN);
    }

    @Override
    public boolean isPrincipleUser() {
        return isPrincipleOfRole(RoleEnum.USER);
    }

    @Override
    public boolean isPrincipleOfRole(RoleEnum role) {
        return getAuthentication().getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(a -> a.equals(role.name()));
    }
}