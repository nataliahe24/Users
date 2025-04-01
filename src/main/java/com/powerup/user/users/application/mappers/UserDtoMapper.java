package com.powerup.user.users.application.mappers;

import com.powerup.user.users.application.dto.request.CreateUserRequest;
import com.powerup.user.users.application.dto.response.UserResponse;
import com.powerup.user.users.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserDtoMapper {
    UserModel requestToModel(CreateUserRequest createdSellerUserRequest);
    UserResponse modelToResponse(UserModel userModel);
}
