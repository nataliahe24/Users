package com.powerup.user.users.domain.ports.out;

import com.powerup.user.users.domain.model.UserModel;

public interface AuthPersistencePort {

    UserModel getUserByEmail(String email);
}
