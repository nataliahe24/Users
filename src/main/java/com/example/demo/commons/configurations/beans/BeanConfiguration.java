package com.example.demo.commons.configurations.beans;
import com.example.demo.users.domain.ports.in.UserServicePort;
import com.example.demo.users.domain.ports.out.UserPersistencePort;
import com.example.demo.users.domain.usecases.UserUseCase;
import com.example.demo.users.infrastructure.adapters.persistence.UserPersistenceAdapter;
import com.example.demo.users.infrastructure.mappers.UserEntityMapper;
import com.example.demo.users.infrastructure.repositories.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Bean
    public UserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }

    @Bean
    public UserPersistencePort userPersistencePort() {
        return new UserPersistenceAdapter(userRepository, userEntityMapper);
    }
}
