package com.example.demo.users.domain.usecases;

import com.example.demo.users.domain.exceptions.SellerUserAlreadyExistsException;
import com.example.demo.users.domain.model.UserModel;
import com.example.demo.users.domain.ports.in.UserServicePort;
import com.example.demo.users.domain.ports.out.UserPersistencePort;

public class UserUseCase implements UserServicePort {
    private final UserPersistencePort userPersistencePort;

    public UserUseCase(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void create(UserModel userModel) {
        UserModel user = userPersistencePort.getUserByEmail(userModel.getEmail());
        if (user != null) {
            throw new SellerUserAlreadyExistsException();
        }
        userPersistencePort.create(userModel);
    }


}
