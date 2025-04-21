package com.powerup.user.users.domain.usecases;

import com.powerup.user.users.domain.exceptions.CredentialsInvalidException;
import com.powerup.user.users.domain.model.UserModel;
import com.powerup.user.users.domain.ports.in.AuthServicePort;
import com.powerup.user.users.domain.ports.out.UserPersistencePort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthUseCase implements AuthServicePort {

    private final UserPersistencePort userPersistencePort;
    private final PasswordEncoder passwordEncoder;

    public AuthUseCase(UserPersistencePort userPersistencePort, PasswordEncoder passwordEncoder) {
        this.userPersistencePort = userPersistencePort;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserModel login(String email, String password) {
        UserModel user = userPersistencePort.getUserByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con correo: " + email);
        }

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new CredentialsInvalidException();
        }

        return user;
    }
}
