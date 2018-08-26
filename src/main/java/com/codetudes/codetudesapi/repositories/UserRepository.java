package com.codetudes.codetudesapi.repositories;

import com.codetudes.codetudesapi.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
