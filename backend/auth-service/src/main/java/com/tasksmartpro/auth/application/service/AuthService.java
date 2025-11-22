package com.tasksmartpro.auth.application.service;

import com.tasksmartpro.auth.application.dto.*;
import com.tasksmartpro.auth.application.ports.in.AuthUseCase;
import com.tasksmartpro.auth.application.ports.out.UserRepositoryPort;
import com.tasksmartpro.auth.config.security.JwtService;
import com.tasksmartpro.auth.domain.enums.Role;
import com.tasksmartpro.auth.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    @Override
    @Transactional
    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail().trim().toLowerCase())
                .password(encoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        User created = userRepositoryPort.save(user);
        return generateTokens(created);
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        User user = userRepositoryPort.findByEmail(request.getEmail().trim().toLowerCase())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!encoder.matches(request.getPassword(), user.getPassword()))
            throw new RuntimeException("Senha inválida");

        return generateTokens(user);
    }

    private AuthResponse generateTokens(User user) {
        return AuthResponse.builder()
                .token(jwtService.generateToken(user.getEmail()))
                .refreshToken(jwtService.generateRefreshToken(user.getEmail()))
                .build();
    }
}
