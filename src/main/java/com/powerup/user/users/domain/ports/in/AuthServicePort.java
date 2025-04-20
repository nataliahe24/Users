package com.powerup.user.users.domain.ports.in;

import com.powerup.user.users.domain.model.UserModel;

public interface AuthServicePort {
    UserModel login(String email, String password);
}
