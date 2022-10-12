package case_study.task_1.utils;

import case_study.task_1.utils.validate.input_person.*;

import java.time.LocalDate;

public class InputPerson {
    public static String name;
    public static LocalDate dateOfBirth;
    public static String gender;
    public static String idCard;
    public static String phoneNumber;
    public static String email;

    public static void inputPerson() {
        name = InputNameUltils.inputName();
        dateOfBirth = InputDateOfBirthUltils.inputDateOfBirth();
        gender = InputGenderUltils.inputGender();
        idCard = InputIdCardUltils.inputIdCard();
        phoneNumber = InputPhoneNumberUltils.inputPhoneNumber();
        email = InputEmailUltils.inputEmail();
    }

}
