package com.example.demo.users.domain.utils.validation;

import com.example.demo.users.domain.exceptions.ExceededAgeAllowed;

import java.time.LocalDate;
import java.time.Period;

import static com.example.demo.users.domain.utils.constants.DomainConstants.MIN_AGE_ALLOWED;

public class ValidAge {

    private ValidAge() {
        throw new UnsupportedOperationException("Utility class - Cannot be instantiated");
    }

   public static void validateBirthDate(LocalDate birthDate) {
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        if (age < MIN_AGE_ALLOWED) {
            throw new ExceededAgeAllowed();
        }
    }
}
