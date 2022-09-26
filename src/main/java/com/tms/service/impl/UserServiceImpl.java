package com.tms.service.impl;

import com.tms.dto.UserDto;
import com.tms.entity.User;
import com.tms.exception.validation.*;
import com.tms.mapper.UserMapper;
import com.tms.repository.UserRepository;
import com.tms.security.UserDetailsImpl;
import com.tms.service.UserService;
import com.tms.util.PatternUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public List<UserDto> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto register(UserDto user) {
        return mapper.toDto(repository.save(mapper.toEntity(user)));
    }

    @Override
    public void validateNewUser(UserDto user) {
        if (!PatternUtils.isEmail(user.getEmail()))
            throw new EmailNotValidException(user.getEmail());
        if (!PatternUtils.isUsername(user.getUsername()))
            throw new UsernameNotValidException(user.getUsername());
        if (repository.isEmailTaken(user.getEmail()))
            throw new EmailTakenException(user.getEmail());
        if (repository.isUsernameTaken(user.getUsername()))
            throw new UsernameTakenException(user.getUsername());
        validateNewPassword(user.getPassword());
    }

    private void validateNewPassword(String password) {
        if (password.length() < 8)
            throw WeakPasswordException.tooShort();
        if (!PatternUtils.containsUppercase(password))
            throw WeakPasswordException.noUppercase();
        if (!PatternUtils.containsDigits(password))
            throw WeakPasswordException.noDigit();
        if (!PatternUtils.containsSymbols(password))
            throw WeakPasswordException.noSymbol();
    }
}
