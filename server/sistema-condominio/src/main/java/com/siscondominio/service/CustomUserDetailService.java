package com.siscondominio.service;

import java.util.Optional;

import com.siscondominio.model.Usuarios;
import com.siscondominio.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios user = Optional.ofNullable(userRepository.findByUsername(username))
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    
}