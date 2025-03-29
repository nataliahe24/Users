package com.example.demo.users.application.services.impl;

import com.example.demo.commons.configurations.utils.Constants;
import com.example.demo.users.application.dto.request.CreateUserRequest;
import com.example.demo.users.application.dto.response.CreateUserResponse;
import com.example.demo.users.application.mappers.UserDtoMapper;
import com.example.demo.users.application.services.UserService;
import com.example.demo.users.domain.ports.in.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserServicePort userServicePort;
    private final UserDtoMapper userDtoMapper;

    @Override
    public CreateUserResponse create(CreateUserRequest request) {
        userServicePort.create(userDtoMapper.requestToModel(request));
        return new CreateUserResponse(Constants.CREATE_USERS_RESPONSE_MESSAGE, LocalDateTime.now());
    }
}
