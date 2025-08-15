package com.powerup.user.users.domain.utils.validation;

import com.powerup.user.users.domain.exceptions.ExceededAgeAllowed;

import java.time.LocalDate;
import java.time.Period;

import static com.powerup.user.users.domain.utils.constants.UserDomainConstants.MIN_AGE_ALLOWED;

public class ValidAge {

    private ValidAge() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void validateBirthDate(LocalDate birthDate) {
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        if (age < MIN_AGE_ALLOWED) {
            throw new ExceededAgeAllowed();
        }
    }
}
