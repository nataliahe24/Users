package com.example.demo.users.domain.model;

import com.example.demo.users.domain.exceptions.*;
import com.example.demo.users.domain.utils.constants.DomainConstants;
import com.example.demo.users.domain.utils.validation.ValidAge;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Objects;
import static com.example.demo.users.domain.utils.constants.DomainConstants.*;

@Getter
@Setter
public class UserModel {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer identityDocument;
    private String phoneNumber;
    private LocalDate birthDate;
    private String email;
    private String password;
    private String role;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // Instancia de BCrypt


    public UserModel(String firstName, String lastName, Integer identityDocument, String phoneNumber,
                     LocalDate birthDate, String email, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityDocument = identityDocument;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = passwordEncoder.encode(password);
        this.role = role;

        if (phoneNumber.length() > FIELD_PHONE_NUMBER_CHARACTERS) {
            throw new PhoneNumberExceededException();
        }

        if (phoneNumber.chars().filter(ch -> ch == '+').count() > FIELD_PHONE_NUMBER_SYMBOL) {
            throw new PhoneNumberCharacterInvalid();
        }

        ValidAge.validateBirthDate(birthDate);

        }


        public void setFirstName (String firstName){
            this.firstName = Objects.requireNonNull(firstName, DomainConstants.FIELD_FIRSTNAME_NULL_MESSAGE);
        }
        public void setLastName (String lastName){
            this.lastName = Objects.requireNonNull(lastName, DomainConstants.FIELD_LASTNAME_NULL_MESSAGE);
        }
        public void setIdentityDocument (Integer identityDocument){
            this.identityDocument = Objects.requireNonNull(identityDocument, DomainConstants.FIELD_IDENTITY_DOCUMENT_NULL_MESSAGE);
        }
        public void setPhoneNumber (String phoneNumber){
            this.phoneNumber = Objects.requireNonNull(phoneNumber, DomainConstants.FIELD_PHONE_NUMBER_NULL_MESSAGE);
        }

        public void setBirthDate (LocalDate birthDate){
        this.birthDate = Objects.requireNonNull(birthDate, DomainConstants.FIELD_BIRTH_DATE_NULL_MESSAGE);
        }

         public void setEmail(String email) {
             this.email = Objects.requireNonNull(email, DomainConstants.FIELD_EMAIL_NULL_MESSAGE);
         }
         public void setRole(String role) {
        this.role = Objects.requireNonNull(role, FIELD_ROLE_NULL_MESSAGE);
        }

        public void setPassword(String encodedPassword) {
    }
}
