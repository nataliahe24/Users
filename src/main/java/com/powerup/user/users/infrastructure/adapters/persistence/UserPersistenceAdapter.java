package com.powerup.user.users.infrastructure.adapters.persistence;

import com.powerup.user.users.domain.model.UserModel;
import com.powerup.user.users.domain.ports.out.UserPersistencePort;
import com.powerup.user.users.infrastructure.mappers.UserEntityMapper;
import com.powerup.user.users.infrastructure.repositories.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public void create(UserModel userModel) {
        userRepository.save(userEntityMapper.modelToEntity(userModel));
    }

    @Override
    public UserModel getUserByEmail(String userEmail) {
        return userEntityMapper.entityToModel(userRepository.findByEmail(userEmail).orElse(null));
    }

}
