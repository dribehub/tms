package com.tms.service;

import com.tms.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();

    List<UserDto> getActive();

    List<UserDto> getNotActive();

    UserDto getById(Integer id);

    UserDto register(UserDto user);

    UserDto update(UserDto user);

    UserDto activateById(Integer id);

    UserDto deleteById(Integer id);
}
