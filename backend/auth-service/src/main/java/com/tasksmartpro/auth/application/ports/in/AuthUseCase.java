package com.tasksmartpro.auth.application.ports.in;

import com.tasksmartpro.auth.application.dto.*;

public interface AuthUseCase {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
