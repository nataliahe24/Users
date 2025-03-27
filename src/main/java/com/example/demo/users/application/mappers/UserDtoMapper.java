package com.example.demo.users.application.mappers;

import com.example.demo.users.application.dto.request.CreateUserRequest;
import com.example.demo.users.application.dto.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserDtoMapper {
    com.example.demo.users.domain.model.UserModel requestToModel(CreateUserRequest createdSellerUserRequest);
    UserResponse modelToResponse(com.example.demo.users.domain.model.UserModel usersModel);
}
