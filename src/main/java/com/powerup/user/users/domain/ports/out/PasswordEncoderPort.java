package com.powerup.user.users.domain.ports.out;

public interface PasswordEncoderPort {
     String encode(String password);
     boolean matches(String rawPassword, String encodedPassword);
}
