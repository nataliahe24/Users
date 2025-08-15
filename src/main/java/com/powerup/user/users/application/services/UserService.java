package com.powerup.user.users.application.services;

import com.powerup.user.users.application.dto.request.CreateUserRequest;
import com.powerup.user.users.application.dto.response.CreateUserResponse;

public interface UserService {

    CreateUserResponse create(CreateUserRequest request);
}
