package com.example.demo.users.domain.usecases;

import com.example.demo.users.domain.model.UserModel;
import com.example.demo.users.domain.ports.out.PasswordEncoderPort;
import com.example.demo.users.domain.ports.out.UserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserUseCaseTest {

    private String firstName;
    private String lastName;
    private Integer identityDocument;
    private String phoneNumber;
    private LocalDate birthDate;
    private String email;
    private String password;
    private String encodedPassword;
    private String role;

    @Mock
    private UserPersistencePort userPersistencePort;
    private PasswordEncoderPort passwordEncoderPort;

    @InjectMocks
    private  UserUseCase userUseCase;

    @BeforeEach
    void setUp() { MockitoAnnotations.openMocks(this);

        userPersistencePort = mock(UserPersistencePort.class);
        passwordEncoderPort = mock(PasswordEncoderPort.class);
        userUseCase = new UserUseCase(userPersistencePort, passwordEncoderPort);

        firstName = "John";
        lastName = "Doe";
        identityDocument = 123456789;
        phoneNumber = "1234567890";
        birthDate = LocalDate.of(1990, 1, 1);
        email = "johndoe@example.com";
        password ="securePassword";
        encodedPassword = "encodedPassword123";
        role = "SELLER";

    }

    @Test
    void shouldCreateUserSuccessfully() {

        when(userPersistencePort.getUserByEmailAndIdentityDocument(email, identityDocument)).thenReturn(null);
        when(passwordEncoderPort.encode(password)).thenReturn(encodedPassword);

        UserModel userModel = new UserModel(firstName, lastName, identityDocument, phoneNumber, birthDate, email, password, role);
        userUseCase.create(userModel);

        ArgumentCaptor<UserModel> userCaptor = ArgumentCaptor.forClass(UserModel.class);
        verify(userPersistencePort).create(userCaptor.capture());
        UserModel savedUser = userCaptor.getValue();

        assertNotNull(savedUser);
        assertEquals(firstName, savedUser.getFirstName());
        assertEquals(lastName, savedUser.getLastName());
        assertEquals(identityDocument, savedUser.getIdentityDocument());
        assertEquals(email, savedUser.getEmail());
        assertEquals(encodedPassword, savedUser.getPassword());
        verify(passwordEncoderPort).encode(password);
    }
}