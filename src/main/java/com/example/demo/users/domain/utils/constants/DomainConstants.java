package com.example.demo.users.domain.utils.constants;


public final class DomainConstants {
    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }
    public static final String FIELD_FIRSTNAME_NULL_MESSAGE = "Atributo 'nombre' no puede ser nulo";
    public static final String FIELD_LASTNAME_NULL_MESSAGE = "Atributo 'Apellido' no puede ser nulo";
    public static final String FIELD_IDENTITY_DOCUMENT_NULL_MESSAGE = "Atributo 'Documento de identidad' no puede ser nulo";
    public static final String FIELD_PHONE_NUMBER_NULL_MESSAGE = "Atributo 'Número de teléfono' no puede ser nulo";
    public static final String FIELD_BIRTH_DATE_NULL_MESSAGE = "Atributo 'Fecha de nacimiento' no puede ser nulo";
    public static final String FIELD_EMAIL_NULL_MESSAGE = "Atributo 'Email' no puede ser nulo";
    public static final String FIELD_ROLE_NULL_MESSAGE = "Atributo 'Rol' no puede ser nulo";
    public static final Integer MIN_AGE_ALLOWED = 18;
    public static final Integer FIELD_PHONE_NUMBER_SYMBOL = 1;
    public static final Integer FIELD_PHONE_NUMBER_CHARACTERS = 13;
}
