package com.codetudes.codetudesapi.config.security;

import com.codetudes.codetudesapi.domain.User;
import com.codetudes.codetudesapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User existingUser = userRepository.findByEmail(username);
        if (null == existingUser) { throw new UsernameNotFoundException("Username not found"); }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                existingUser.getEmail(), existingUser.getSecret(), authorities);

        return userDetails;
    }
}
