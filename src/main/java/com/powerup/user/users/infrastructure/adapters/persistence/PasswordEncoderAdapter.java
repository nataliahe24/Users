package com.powerup.user.users.infrastructure.adapters.persistence;

import com.powerup.user.users.domain.ports.out.PasswordEncoderPort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderAdapter implements PasswordEncoderPort {
        private final PasswordEncoder passwordEncoder;

        public PasswordEncoderAdapter(PasswordEncoder passwordEncoder) {
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        public String encode(String password) {
            return passwordEncoder.encode(password);
        }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return false;
    }

}

