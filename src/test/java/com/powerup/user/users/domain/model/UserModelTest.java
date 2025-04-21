package com.powerup.user.users.domain.model;

import com.powerup.user.users.domain.exceptions.PhoneNumberCharacterInvalid;
import com.powerup.user.users.domain.exceptions.PhoneNumberExceededException;
import com.powerup.user.users.domain.utils.constants.Role;
import com.powerup.user.users.domain.utils.constants.UserDomainConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    private RoleModel role;


    @BeforeEach
    void setUp() {

        firstName = "John";
        lastName = "Doe";
        identityDocument = 123456789;
        phoneNumber = "1234567890";
        birthDate = LocalDate.of(1990, 1, 1);
        email = "johndoe@example.com";
        password = "securepassword";
        role = new RoleModel(2L, "SELLER", "ROLE");

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
        assertEquals(password, user.getPassword());

    }

    @Test
    void shouldPhoneNumberHas13CharactersOrLess() {
        String validPhoneNumber = UserDomainConstants.FIELD_PHONE_NUMBER_VALID_CHARACTERS;

        assertDoesNotThrow(() -> new UserModel(firstName, lastName, identityDocument, validPhoneNumber, birthDate, email, password, role));
    }

    @Test
    void shouldThrowExceptionWhenPhoneNumberExceeds13Characters() {
        String invalidPhoneNumber = UserDomainConstants.FIELD_PHONE_NUMBER_EXCEEDED_CHARACTERS;

        assertThrows(PhoneNumberExceededException.class, () -> new UserModel(firstName, lastName, identityDocument, invalidPhoneNumber, birthDate, email, password, role));
    }

    @Test
    void shouldThrowExceptionWhenPhoneNumberHasCharactersInvalid() {
        String invalidPhoneNumber = UserDomainConstants.FIELD_PHONE_CHARACTERS_INVALID;
        assertThrows(PhoneNumberCharacterInvalid.class, () -> new UserModel(firstName, lastName, identityDocument, invalidPhoneNumber, birthDate, email, password, role));
    }

    @Test
    void shouldThrowExceptionWhenFirstNameIsNull() {
        UserModel newUser = new UserModel(firstName, lastName, identityDocument, phoneNumber, birthDate, email, password, role);

        NullPointerException exception = assertThrows(NullPointerException.class, () -> newUser.setFirstName(null));
        assertEquals(UserDomainConstants.FIELD_FIRSTNAME_NULL_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenLastNameIsNull() {
        UserModel newUser = new UserModel(firstName, lastName, identityDocument, phoneNumber, birthDate, email, password, role);

        NullPointerException exception = assertThrows(NullPointerException.class, () -> newUser.setLastName(null));
        assertEquals(UserDomainConstants.FIELD_LASTNAME_NULL_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenIdentityDocumentIsNull() {
        UserModel newUser = new UserModel(firstName, lastName, identityDocument, phoneNumber, birthDate, email, password, role);

        NullPointerException exception = assertThrows(NullPointerException.class, () -> newUser.setIdentityDocument(null));
        assertEquals(UserDomainConstants.FIELD_IDENTITY_DOCUMENT_NULL_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenPhoneNumberIsNull() {
        UserModel newUser = new UserModel(firstName, lastName, identityDocument, phoneNumber, birthDate, email, password, role);

        NullPointerException exception = assertThrows(NullPointerException.class, () -> newUser.setPhoneNumber(null));
        assertEquals(UserDomainConstants.FIELD_PHONE_NUMBER_NULL_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenBirthDateIsNull() {
        UserModel newUser = new UserModel(firstName, lastName, identityDocument, phoneNumber, birthDate, email, password, role);

        NullPointerException exception = assertThrows(NullPointerException.class, () -> newUser.setBirthDate(null));
        assertEquals(UserDomainConstants.FIELD_BIRTH_DATE_NULL_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenEmailIsNull() {
        UserModel newUser = new UserModel(firstName, lastName, identityDocument, phoneNumber, birthDate, email, password, role);

        NullPointerException exception = assertThrows(NullPointerException.class, () -> newUser.setEmail(null));
        assertEquals(UserDomainConstants.FIELD_EMAIL_NULL_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenPasswordIsNull() {
        UserModel newUser = new UserModel(firstName, lastName, identityDocument, phoneNumber, birthDate, email, password, role);

        NullPointerException exception = assertThrows(NullPointerException.class, () -> newUser.setPassword(null));
        assertEquals(UserDomainConstants.FIELD_PASSWORD_NULL_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenRoleIsNull() {
        UserModel newUser = new UserModel(firstName, lastName, identityDocument, phoneNumber, birthDate, email, password, role);

        NullPointerException exception = assertThrows(NullPointerException.class, () -> newUser.setRole(null));
        assertEquals(UserDomainConstants.FIELD_ROLE_NULL_MESSAGE, exception.getMessage());
    }

}
