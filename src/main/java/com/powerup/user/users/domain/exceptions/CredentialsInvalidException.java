package com.powerup.user.users.domain.exceptions;

public class CredentialsInvalidException extends RuntimeException {
    public CredentialsInvalidException(String message) {
        super(message);
    }
}
