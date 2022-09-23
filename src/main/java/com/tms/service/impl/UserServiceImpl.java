package com.tms.service.impl;

import com.tms.mapper.UserMapper;
import com.tms.repository.UserRepository;
import com.tms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
}
