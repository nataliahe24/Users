package com.powerup.user.users.infrastructure.adapters.persistence;

import com.powerup.user.users.domain.ports.out.PasswordEncoderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordEncoderAdapter implements PasswordEncoderPort {
        private final PasswordEncoder passwordEncoder;


        @Override
        public String encode(String password) {
            return passwordEncoder.encode(password);
        }

}

