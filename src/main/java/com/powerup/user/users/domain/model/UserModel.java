package com.powerup.user.users.domain.model;

import com.powerup.user.users.domain.exceptions.PhoneNumberCharacterInvalid;
import com.powerup.user.users.domain.exceptions.PhoneNumberExceededException;
import com.powerup.user.users.domain.utils.constants.UserDomainConstants;
import com.powerup.user.users.domain.utils.validation.ValidAge;
import com.powerup.user.users.domain.utils.validation.ValidEmail;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.Objects;
import static com.powerup.user.users.domain.utils.constants.UserDomainConstants.*;

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


    public UserModel(String firstName, String lastName, Integer identityDocument, String phoneNumber,
                     LocalDate birthDate, String email, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityDocument = identityDocument;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.role = role;

        if (phoneNumber.length() > FIELD_PHONE_NUMBER_CHARACTERS) {
            throw new PhoneNumberExceededException();
        }

        if (phoneNumber.chars().filter(ch -> ch == '+').count() > FIELD_PHONE_NUMBER_SYMBOL) {
            throw new PhoneNumberCharacterInvalid();
        }

        ValidAge.validateBirthDate(birthDate);
        ValidEmail.isValidEmail(email);

        }


        public void setFirstName (String firstName){
            this.firstName = Objects.requireNonNull(firstName, UserDomainConstants.FIELD_FIRSTNAME_NULL_MESSAGE);
        }
        public void setLastName (String lastName){
            this.lastName = Objects.requireNonNull(lastName, UserDomainConstants.FIELD_LASTNAME_NULL_MESSAGE);
        }
        public void setIdentityDocument (Integer identityDocument){
            this.identityDocument = Objects.requireNonNull(identityDocument, UserDomainConstants.FIELD_IDENTITY_DOCUMENT_NULL_MESSAGE);
        }
        public void setPhoneNumber (String phoneNumber){
            this.phoneNumber = Objects.requireNonNull(phoneNumber, UserDomainConstants.FIELD_PHONE_NUMBER_NULL_MESSAGE);
        }

        public void setBirthDate (LocalDate birthDate){
        this.birthDate = Objects.requireNonNull(birthDate, UserDomainConstants.FIELD_BIRTH_DATE_NULL_MESSAGE);
        }

         public void setEmail(String email) {
             this.email = Objects.requireNonNull(email, UserDomainConstants.FIELD_EMAIL_NULL_MESSAGE);
         }

         public void setPassword(String password) {
             this.password = Objects.requireNonNull(password, FIELD_PASSWORD_NULL_MESSAGE);

         }
         public void setRole(String role) {
        this.role = Objects.requireNonNull(role, FIELD_ROLE_NULL_MESSAGE);
        }

}
