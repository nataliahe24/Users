package com.powerup.user.commons.configurations.beans;
import com.powerup.user.users.domain.ports.in.UserServicePort;
import com.powerup.user.users.domain.ports.out.PasswordEncoderPort;
import com.powerup.user.users.domain.ports.out.UserPersistencePort;
import com.powerup.user.users.domain.usecases.UserUseCase;
import com.powerup.user.users.infrastructure.adapters.persistence.PasswordEncoderAdapter;
import com.powerup.user.users.infrastructure.adapters.persistence.UserPersistenceAdapter;
import com.powerup.user.users.infrastructure.mappers.UserEntityMapper;
import com.powerup.user.users.infrastructure.repositories.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Bean
    public UserServicePort userServicePort(UserPersistencePort userPersistencePort,PasswordEncoderPort passwordEncoderPort) {
        return new UserUseCase(userPersistencePort, passwordEncoderPort);
    }

    @Bean
    public UserPersistencePort userPersistencePort() {
        return new UserPersistenceAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public PasswordEncoderPort passwordEncoderPort(PasswordEncoder passwordEncoder) {
        return new PasswordEncoderAdapter(passwordEncoder);
    }
}
