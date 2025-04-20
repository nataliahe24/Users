package com.powerup.user.users.domain.usecases;

import com.powerup.user.users.domain.model.RoleModel;
import com.powerup.user.users.domain.model.UserModel;
import com.powerup.user.users.domain.ports.out.PasswordEncoderPort;
import com.powerup.user.users.domain.ports.out.UserPersistencePort;
import com.powerup.user.users.domain.utils.constants.Role;
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
    private RoleModel role;

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
        role = new RoleModel(2L, "SELLER", "ROLE");

    }

    @Test
    void shouldCreateUserSuccessfully() {

        when(userPersistencePort.getUserByEmail(email)).thenReturn(null);
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