package com.powerup.user.users.domain.usecases;


import com.powerup.user.users.domain.exceptions.UserAlreadyExistsException;
import com.powerup.user.users.domain.model.UserModel;
import com.powerup.user.users.domain.ports.in.UserServicePort;
import com.powerup.user.users.domain.ports.out.PasswordEncoderPort;
import com.powerup.user.users.domain.ports.out.UserPersistencePort;

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
        UserModel newUser = new UserModel(userModel.getFirstName(),
                userModel.getLastName(),
                userModel.getIdentityDocument(),
                userModel.getPhoneNumber(),
                userModel.getBirthDate(),
                userModel.getEmail(),
                encodedPassword,
                userModel.getRole()
        );

        userPersistencePort.create(newUser);
    }

}
