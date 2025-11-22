package com.tasksmartpro.auth.adapters.out.db;

import com.tasksmartpro.auth.adapters.out.db.entity.UserEntity;
import com.tasksmartpro.auth.adapters.out.db.repository.UserJpaRepository;
import com.tasksmartpro.auth.application.mapper.UserMapper;
import com.tasksmartpro.auth.application.ports.out.UserRepositoryPort;
import com.tasksmartpro.auth.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserJpaRepository repo;

    @Override
    public User save(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        UserEntity saved = repo.save(entity);
        return UserMapper.toDomain(saved);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repo.findByEmail(email)
                .map(UserMapper::toDomain);
    }
}
