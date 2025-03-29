package com.example.demo.users.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class UserModelTest {

    private String firstName;
    private String lastName;
    private Integer identityDocument;
    private String phoneNumber;
    private LocalDate birthDate;
    private String email;
    private String password;
    private String role;


    @BeforeEach
    void setUp() {

        firstName = "John";
        lastName = "Doe";
        identityDocument = 123456789;
        phoneNumber = "1234567890";
        birthDate = LocalDate.of(1990, 1, 1);
        email = "johndoe@example.com";
        password = "securepassword";
        role = "USER";

    }

    @Test
    void shouldCreateUserSuccessfully() {
        UserModel user = new UserModel(firstName, lastName, identityDocument, phoneNumber, birthDate, email, password, role);

        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(identityDocument, user.getIdentityDocument());
        assertEquals(phoneNumber, user.getPhoneNumber());
        assertEquals(birthDate, user.getBirthDate());
        assertEquals(email, user.getEmail());
        assertEquals(role, user.getRole());
        assertNotNull(user.getPassword());
        assertNotEquals(password, user.getPassword());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        assertNotNull(user.getPassword());
        assertTrue(passwordEncoder.matches(password, user.getPassword()), "La contraseña codificada no coincide.");
    }
}