package com.example.demo.users.domain.ports.in;

import com.example.demo.users.domain.model.UserModel;



public interface UserServicePort {
    void create(UserModel usersModel);

}
