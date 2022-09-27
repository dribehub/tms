package com.tms.service.impl;

import com.tms.entity.User;
import com.tms.repository.UserRepository;
import com.tms.dto.details.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        String error = String.format("Couldn't load user with username '%s'", username);
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(error));
        return UserDetailsImpl.build(user);
    }

}