package com.tms.service;

import com.tms.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAll(Boolean isActive, Boolean isApproved);

    UserDto getById(Integer id);

    UserDto register(UserDto user);

    UserDto update(Integer id, UserDto user);

    UserDto setApprovedById(Integer id, boolean isApproved);

    UserDto deleteById(Integer id);

    UserDto restoreById(Integer id);
}
