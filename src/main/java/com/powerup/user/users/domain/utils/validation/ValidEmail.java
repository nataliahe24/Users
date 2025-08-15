package com.powerup.user.users.domain.utils.validation;

import com.powerup.user.users.domain.exceptions.EmailStructureInvalid;
import com.powerup.user.users.domain.utils.constants.UserDomainConstants;

import java.util.regex.Pattern;

public class ValidEmail {

    private ValidEmail() {
        throw new UnsupportedOperationException("Utility class");
    }

    private static final Pattern pattern = Pattern.compile(UserDomainConstants.EMAIL_STRUCTURE);

    public static void isValidEmail(String email) {
        if (email == null || email.trim().isEmpty() || !pattern.matcher(email).matches()) {
            throw new EmailStructureInvalid();
        }
    }
}
