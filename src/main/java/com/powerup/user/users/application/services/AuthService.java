package com.powerup.user.users.application.services;

import com.powerup.user.users.application.dto.request.LoginUserRequest;
import com.powerup.user.users.application.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse loginUser(LoginUserRequest request);
}
