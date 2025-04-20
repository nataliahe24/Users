package com.powerup.user.users.infrastructure.adapters.persistence;

import com.powerup.user.users.domain.model.UserModel;
import com.powerup.user.users.domain.ports.out.AuthPersistencePort;
import com.powerup.user.users.infrastructure.mappers.UserEntityMapper;
import com.powerup.user.users.infrastructure.repositories.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Component
public class AuthPersistenceAdapter implements AuthPersistencePort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public UserModel getUserByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail)
                .map(userEntityMapper::entityToModel)
                .orElse(null);
    }
}
