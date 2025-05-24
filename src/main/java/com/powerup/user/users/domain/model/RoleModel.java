package com.powerup.user.users.domain.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RoleModel {

    private Long id;
    private String name;
    private String description;


    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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
