package com.tms.mapper;

import com.tms.dto.UserDto;
import com.tms.entity.User;
import com.tms.dto.details.UserDetailsImpl;

import java.util.List;

public interface UserMapper {

    User toEntity(UserDto dto);

    List<User> toEntities(List<UserDto> dtos);

    UserDto toDto(User entity);

    List<UserDto> toDtos(List<User> entities);

    UserDetailsImpl toDetails(User entity);

    UserDetailsImpl toDetails(UserDto dto);
}
