package com.minhtien.validation;

public class Validation {
    private static final String REGEX_EMAIL = "^[([A-Za-z]+)([0-9]*)]{5,30}@[a-z]+(\\.[a-z]+)$";


    public static boolean checkEmail(String email) {
        return email.matches(REGEX_EMAIL);
    }
}
