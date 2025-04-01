package com.powerup.user.users.application.dto.response;

import java.time.LocalDate;

public record UserResponse(Long id, String firstName, String lastName, Integer identityDocument, String phoneNumber,
                           LocalDate birthDate, String email, String password) {
}
