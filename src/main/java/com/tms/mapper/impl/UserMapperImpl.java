package com.tms.mapper.impl;

import com.tms.dto.UserDto;
import com.tms.entity.User;
import com.tms.mapper.UserMapper;
import com.tms.dto.details.UserDetailsImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto dto) {
        return dto == null ? null : new User(
                dto.getId(),
                dto.getUsername(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getRoles()
        );
    }

    @Override
    public UserDetailsImpl toDetails(User entity) {
        return entity == null ? null : new UserDetailsImpl(
                entity.getId(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getRoles()
        );
    }

    @Override
    public UserDto toDto(User entity) {
        return entity == null ? null : new UserDto(
                entity.getId(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getRoles()
        );
    }

    @Override
    public UserDetailsImpl toDetails(UserDto dto) {
        return dto == null ? null : new UserDetailsImpl(
                dto.getId(),
                dto.getUsername(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getRoles()
        );
    }
}
