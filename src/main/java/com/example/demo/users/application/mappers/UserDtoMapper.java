package com.example.demo.users.application.mappers;

import com.example.demo.users.application.dto.request.CreateUserRequest;
import com.example.demo.users.application.dto.response.UserResponse;
import com.example.demo.users.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserDtoMapper {
    UserModel requestToModel(CreateUserRequest createdSellerUserRequest);
    UserResponse modelToResponse(UserModel userModel);
}
