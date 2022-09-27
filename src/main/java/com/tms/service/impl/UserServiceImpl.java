package com.tms.service.impl;

import com.tms.dto.UserDto;
import com.tms.entity.User;
import com.tms.exception.db.EntityNotFoundException;
import com.tms.exception.validation.user.*;
import com.tms.mapper.UserMapper;
import com.tms.repository.UserRepository;
import com.tms.service.UserService;
import com.tms.util.PatternUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder encoder;

    @Override
    public List<UserDto> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getById(Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(User.class, id)));
    }

    @Override
    public UserDto register(UserDto user) {
        validateNewUser(user);
        user.setPassword(encoder.encode(user.getPassword()));
        if (user.getRoles() == null || user.getRoles().isEmpty())
            user.setRoleAsUser();
        return mapper.toDto(repository.save(mapper.toEntity(user)));
    }

    private void validateNewUser(UserDto user) {
        if (!PatternUtils.isEmail(user.getEmail()))
            throw new InvalidEmailFormatException(user.getEmail());
        if (!PatternUtils.isUsername(user.getUsername()))
            throw new InvalidUsernameException(user.getUsername());
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

    @Override
    public UserDto update(UserDto user) {
        repository.findById(user.getId()).orElseThrow(
                () -> new EntityNotFoundException(User.class, user.getId()));
        if (user.getPassword() != null)
            user.setPassword(encoder.encode(user.getPassword()));
        return mapper.toDto(repository.save(mapper.toEntity(user)));
    }

    @Override
    public UserDto deleteById(Integer id) {
        User deleted = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(User.class, id));
        repository.deleteById(id);
        return mapper.toDto(deleted);
    }
}
