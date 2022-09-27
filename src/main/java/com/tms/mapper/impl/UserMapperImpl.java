package com.tms.mapper.impl;

import com.tms.dto.UserDto;
import com.tms.entity.User;
import com.tms.mapper.UserMapper;
import com.tms.dto.details.UserDetailsImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
                dto.getRoles(),
                dto.getCreatedAt(),
                dto.getUpdatedAt(),
                dto.getIsApproved(),
                dto.getIsActive()
        );
    }

    @Override
    public List<User> toEntities(List<UserDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public UserDto toDto(User entity) {
        return entity == null ? null : new UserDto(
                entity.getId(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getRoles(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getIsApproved(),
                entity.getIsActive()
        );
    }

    @Override
    public List<UserDto> toDtos(List<User> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
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
