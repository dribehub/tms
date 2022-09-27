package com.tms.service;

import com.tms.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();

    List<UserDto> getActive();

    List<UserDto> getNotActive();

    List<UserDto> getApproved();

    List<UserDto> getNotApproved();

    UserDto getById(Integer id);

    UserDto register(UserDto user);

    UserDto update(UserDto user);

    UserDto setApprovedById(Integer id, boolean isApproved);

    UserDto deleteById(Integer id);

    UserDto restoreById(Integer id);
}
