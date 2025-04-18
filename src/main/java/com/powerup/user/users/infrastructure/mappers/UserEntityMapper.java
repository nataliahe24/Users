package com.powerup.user.users.infrastructure.mappers;

import com.powerup.user.users.domain.model.UserModel;
import com.powerup.user.users.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring",
        uses = {RoleEntityMapper.class})
public interface UserEntityMapper {
    UserEntity modelToEntity(UserModel userModel);
    UserModel entityToModel(UserEntity userEntity);
}
