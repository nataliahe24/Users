package com.example.demo.users.infrastructure.mappers;

import com.example.demo.users.domain.model.UserModel;
import com.example.demo.users.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    UserEntity modelToEntity(UserModel userModel);
    UserModel entityToModel(UserEntity userEntity);
}
