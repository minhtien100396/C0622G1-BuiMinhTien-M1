package com.minhtien.demo.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PhoneNumberDto implements Validator {
    private String number;


    public PhoneNumberDto() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PhoneNumberDto phoneNumberDto = (PhoneNumberDto) target;
        if (!phoneNumberDto.number.matches("^0[0-9]{9,11}$")){
            errors.rejectValue("number","number.matches");
        }
    }
}
