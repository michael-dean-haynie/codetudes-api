package com.codetudes.codetudesapi.services.impl;

import com.codetudes.codetudesapi.contracts.UserDTO;
import com.codetudes.codetudesapi.domain.User;
import com.codetudes.codetudesapi.repositories.UserRepository;
import com.codetudes.codetudesapi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO){
        // encrypt secret before persistence
        userDTO.setSecret(encoder.encode(userDTO.getSecret()));
//        System.out.println(userDTO.getSecret());
        return mapper.map(userRepository.save(mapper.map(userDTO, User.class)), UserDTO.class);
    }
}
