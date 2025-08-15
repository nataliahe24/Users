package com.powerup.user.users.application.services.impl;

import com.powerup.user.commons.configurations.utils.Constants;
import com.powerup.user.users.application.dto.request.CreateUserRequest;
import com.powerup.user.users.application.dto.response.CreateUserResponse;
import com.powerup.user.users.application.mappers.UserDtoMapper;
import com.powerup.user.users.application.services.UserService;
import com.powerup.user.users.domain.ports.in.UserServicePort;
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
