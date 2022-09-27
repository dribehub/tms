package com.tms.service;

import com.tms.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();

    UserDto getById(Integer id);

    void validateNewUser(UserDto user);

    UserDto register(UserDto user);

    UserDto update(UserDto user);

    UserDto deleteById(Integer id);
}
