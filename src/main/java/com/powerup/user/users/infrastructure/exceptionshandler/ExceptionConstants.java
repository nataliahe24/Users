package com.powerup.user.users.infrastructure.exceptionshandler;

public final class ExceptionConstants {
    private ExceptionConstants(){}

    public static final String PHONE_NUMBER_MAX_SIZE_MESSAGE = "El numero de telefono no puede exceder los 13 caracteres";
    public static final String PHONE_CHARACTER_INVALID_MESSAGE = "El número de teléfono solo puede contener un único signo (+).";
    public static final String USER_EXISTS_EXCEPTION = "El usuario ya existe";
    public static final String EXCEEDED_AGE_EXCEPTION = "La edad del usuario no cumple con el mínimo permitido";
    public static final String EMAIL_INVALID_EXCEPTION ="El correo electrónico ingresado no tiene un formato válido.";
}
