package com.example.demo.users.infrastructure.adapters.persistence;

import com.example.demo.users.domain.model.UserModel;
import com.example.demo.users.domain.ports.out.UserPersistencePort;
import com.example.demo.users.infrastructure.mappers.UserEntityMapper;
import com.example.demo.users.infrastructure.repositories.mysql.UserRepository;
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
    public UserModel getUserByEmailAndIdentityDocument(String userEmail, Integer userIdentityDocument) {
        return userEntityMapper.entityToModel(userRepository.findByEmail(userEmail).orElse(null));
    }

}
