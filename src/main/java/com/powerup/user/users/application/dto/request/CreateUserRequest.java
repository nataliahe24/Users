package com.powerup.user.users.application.dto.request;



import java.time.LocalDate;

public record CreateUserRequest(String firstName, String lastName, Integer identityDocument, String phoneNumber,
                                LocalDate birthDate, String email, String password, String role) {
}
