package com.example.demo.users.domain.ports.out;

import com.example.demo.users.domain.model.UserModel;

public interface UserPersistencePort {
    void create(UserModel userModel);
    UserModel getUserByEmailAndIdentityDocument(String userEmail, Integer userIdentityDocument );
}
