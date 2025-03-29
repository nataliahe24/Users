package com.example.demo.users.infrastructure.adapters.persistence;

import com.example.demo.users.domain.ports.out.PasswordEncoderPort;
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

}

