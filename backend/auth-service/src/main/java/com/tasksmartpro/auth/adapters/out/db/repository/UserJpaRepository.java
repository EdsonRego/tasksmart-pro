package com.tasksmartpro.auth.adapters.out.db.repository;

import com.tasksmartpro.auth.adapters.out.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
