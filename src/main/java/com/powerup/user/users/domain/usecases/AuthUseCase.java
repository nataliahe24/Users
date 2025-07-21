package com.powerup.user.users.domain.usecases;

import com.powerup.user.users.domain.exceptions.CredentialsInvalidException;
import com.powerup.user.users.domain.model.UserModel;
import com.powerup.user.users.domain.ports.in.AuthServicePort;
import com.powerup.user.users.domain.ports.out.UserPersistencePort;
import com.powerup.user.users.domain.utils.constants.UserDomainConstants;
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
            throw new UsernameNotFoundException(UserDomainConstants.USERS_NOT_FOUND + email);
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new CredentialsInvalidException(UserDomainConstants.INVALID_USERS_RESPONSE_MESSAGE);
        }
        return user;
    }
}
