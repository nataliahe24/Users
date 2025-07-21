package com.powerup.user.users.domain.utils.constants;


public final class UserDomainConstants {
    private UserDomainConstants() {
        throw new IllegalStateException("Utility class");
    }
    public static final String FIELD_FIRSTNAME_NULL_MESSAGE = "Atributo 'nombre' no puede ser nulo";
    public static final String FIELD_LASTNAME_NULL_MESSAGE = "Atributo 'Apellido' no puede ser nulo";
    public static final String FIELD_IDENTITY_DOCUMENT_NULL_MESSAGE = "Atributo 'Documento de identidad' no puede ser nulo";
    public static final String FIELD_PHONE_NUMBER_NULL_MESSAGE = "Atributo 'Número de teléfono' no puede ser nulo";
    public static final String FIELD_BIRTH_DATE_NULL_MESSAGE = "Atributo 'Fecha de nacimiento' no puede ser nulo";
    public static final String FIELD_EMAIL_NULL_MESSAGE = "Atributo 'Email' no puede ser nulo";
    public static final String FIELD_PASSWORD_NULL_MESSAGE = "El campo 'contraseña' no puede ser nulo";
    public static final String FIELD_ROLE_NULL_MESSAGE = "Atributo 'Rol' no puede ser nulo";
    public static final Integer MIN_AGE_ALLOWED = 18;
    public static final Integer FIELD_PHONE_NUMBER_SYMBOL = 1;
    public static final Integer FIELD_PHONE_NUMBER_CHARACTERS = 13;
    public static final String FIELD_PHONE_CHARACTERS_INVALID = "++12345678901";
    public static final String FIELD_PHONE_NUMBER_EXCEEDED_CHARACTERS = "12345678901234";
    public static final String FIELD_PHONE_NUMBER_VALID_CHARACTERS = "1234567890123";
    public static final String EMAIL_STRUCTURE = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    public static final String INVALID_USERS_RESPONSE_MESSAGE = "Usuario no encontrado o contraseña incorrecta";
    public static final String USERS_NOT_FOUND = "Usuario no encontrado con correo: ";

}
