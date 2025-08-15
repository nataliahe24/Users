package com.powerup.user.users.domain.ports.out;

import com.powerup.user.users.domain.model.UserModel;

public interface UserPersistencePort {
    void create(UserModel userModel);

    UserModel getUserByEmail(String userEmail);
}
