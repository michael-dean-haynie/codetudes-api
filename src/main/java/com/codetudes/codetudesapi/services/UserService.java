package com.codetudes.codetudesapi.services;

import com.codetudes.codetudesapi.contracts.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
}
