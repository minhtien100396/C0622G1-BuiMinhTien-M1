package case_study.task_1.utils.validate.input_person;

import case_study.task_1.utils.exception.DateException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputDateOfBirthUltils {
    private static Scanner scanner = new Scanner(System.in);

    public static LocalDate inputDateOfBirth() {
        String dateOfBirth;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDay;
        int age;
        while (true) {
            try {
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Mời bạn nhập vào ngày tháng năm sinh (dd/MM/yyyy)");
                dateOfBirth = scanner.nextLine();
                birthDay = LocalDate.parse(dateOfBirth, dateTimeFormatter);
                LocalDate dateNow = LocalDate.now();
                age = dateNow.getYear() - birthDay.getYear();
                if (age < 18 || age > 100) {
                    throw new DateException("Vui lòng nhập ngày tháng năm sinh trong độ tuổi cho phép (18-100)");
                }
                break;
            } catch (DateException e) {
                System.out.println(e.getMessage());
            } catch (DateTimeParseException e) {
                System.out.println("Vui lòng nhập đúng định dạng dd/MM/yyyy");
            }
        }
        return birthDay;

    }
}