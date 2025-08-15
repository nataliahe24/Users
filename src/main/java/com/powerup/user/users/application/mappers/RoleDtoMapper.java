package com.powerup.user.users.application.mappers;


import com.powerup.user.users.domain.model.RoleModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleDtoMapper {
    default RoleModel toRoleModel(Long id) {
        return RoleModel.builder().id(id).build();
    }
    default Long toRoleId(RoleModel roleModel) {
        return  roleModel.getId();
    }

}
