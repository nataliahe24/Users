package com.example.demo.users.application.services;

import com.example.demo.users.application.dto.request.CreateUserRequest;
import com.example.demo.users.application.dto.response.CreateUserResponse;

public interface UserService {

    CreateUserResponse create(CreateUserRequest request);
}
