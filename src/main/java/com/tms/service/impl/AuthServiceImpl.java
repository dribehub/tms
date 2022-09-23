package com.tms.service.impl;

import com.tms.dto.UserDto;
import com.tms.mapper.UserMapper;
import com.tms.repository.UserRepository;
import com.tms.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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
    public UserDto getLoggedInUserDto() {
        return userMapper.toDto(userRepository.findByUsername(getAuthentication().getName()));
    }

    @Override
    public Integer getLoggedInUserId() {
        return getLoggedInUserDto().getId();
    }

    @Override
    public boolean isLoggedInUserAdmin() {
        return getAuthentication().getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(a -> a.equals("admin"));
    }
}