package com.example.demo.users.domain.usecases;

import com.example.demo.users.domain.exceptions.UserAlreadyExistsException;
import com.example.demo.users.domain.model.UserModel;
import com.example.demo.users.domain.ports.in.UserServicePort;
import com.example.demo.users.domain.ports.out.PasswordEncoderPort;
import com.example.demo.users.domain.ports.out.UserPersistencePort;

public class UserUseCase implements UserServicePort {
    private final UserPersistencePort userPersistencePort;
    private final PasswordEncoderPort passwordEncoderPort;

    public UserUseCase(UserPersistencePort userPersistencePort, PasswordEncoderPort passwordEncoderPort) {
        this.userPersistencePort = userPersistencePort;
        this.passwordEncoderPort = passwordEncoderPort;
    }

    @Override
    public void create(UserModel userModel) {
        UserModel user = userPersistencePort.getUserByEmail(userModel.getEmail());
        if (user != null) {
            throw new UserAlreadyExistsException();
        }

        String encodedPassword = passwordEncoderPort.encode(userModel.getPassword());
        userModel.setPassword(encodedPassword);

        userPersistencePort.create(userModel);
    }

}
