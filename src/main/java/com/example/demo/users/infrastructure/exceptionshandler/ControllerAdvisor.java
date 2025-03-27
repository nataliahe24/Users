package com.example.demo.users.infrastructure.exceptionshandler;

import com.example.demo.users.domain.exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(PhoneNumberExceededException.class)
    public ResponseEntity<ExceptionResponse> handleDescriptionMaxSizeExceededException(PhoneNumberExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.PHONE_NUMBER_MAX_SIZE_MESSAGE,
                LocalDateTime.now()));
    }

    @ExceptionHandler(SellerUserAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleUsersAlreadyExistsException(SellerUserAlreadyExistsException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.USER_EXISTS_EXCEPTION,
                LocalDateTime.now()));
    }

    @ExceptionHandler(ExceededAgeAllowed.class)
    public ResponseEntity<ExceptionResponse> handleExceededAgeAllowed(ExceededAgeAllowed exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.EXCEEDED_AGE_EXCEPTION,
                LocalDateTime.now()));
    }

}
