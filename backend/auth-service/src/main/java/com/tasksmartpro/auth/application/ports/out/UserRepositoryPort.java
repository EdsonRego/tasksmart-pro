package com.tasksmartpro.auth.application.ports.out;

import com.tasksmartpro.auth.domain.model.User;

import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findByEmail(String email);
}
