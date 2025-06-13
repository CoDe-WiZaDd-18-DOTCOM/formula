package com.example.formula.entity;

import com.example.formula.repository.UserJwtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserJwtRepository userJwtRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserJwt userJwt = userJwtRepository.findByEmail(username);
        if (userJwt != null) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username(userJwt.getEmail())
                    .password(userJwt.getPassword())
                    .build();
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
