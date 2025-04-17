package com.powerup.user.users.infrastructure.mappers;

import com.powerup.user.users.domain.model.RoleModel;
import com.powerup.user.users.infrastructure.entities.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleEntityMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    RoleEntity modelToEntity(RoleModel roleModel);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    RoleModel entityToModel(RoleEntity roleEntity);
}