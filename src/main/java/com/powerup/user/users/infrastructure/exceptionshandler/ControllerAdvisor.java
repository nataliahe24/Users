package com.powerup.user.users.infrastructure.exceptionshandler;

import com.powerup.user.users.domain.exceptions.ExceededAgeAllowed;
import com.powerup.user.users.domain.exceptions.PhoneNumberCharacterInvalid;
import com.powerup.user.users.domain.exceptions.PhoneNumberExceededException;
import com.powerup.user.users.domain.exceptions.UserAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(PhoneNumberExceededException.class)
    public ResponseEntity<ExceptionResponse> handlePhoneMaxSizeExceededException(PhoneNumberExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.PHONE_NUMBER_MAX_SIZE_MESSAGE,
                LocalDateTime.now()));
    }

    @ExceptionHandler(PhoneNumberCharacterInvalid.class)
    public ResponseEntity<ExceptionResponse> handlePhoneNumberCharacterException(PhoneNumberCharacterInvalid exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.PHONE_CHARACTER_INVALID_MESSAGE,
                LocalDateTime.now()));
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleUsersAlreadyExistsException(UserAlreadyExistsException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.USER_EXISTS_EXCEPTION,
                LocalDateTime.now()));
    }

    @ExceptionHandler(ExceededAgeAllowed.class)
    public ResponseEntity<ExceptionResponse> handleExceededAgeAllowed(ExceededAgeAllowed exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.EXCEEDED_AGE_EXCEPTION,
                LocalDateTime.now()));
    }

}
