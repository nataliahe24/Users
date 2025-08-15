package com.powerup.user.users.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Builder
@Getter
public class RoleModel {

    private Long id;
    private String name;
    private String description;


    public RoleModel(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getName(String name) {
        return name;
    }

    public String getDescription(String description) {
        return description;
    }
}
