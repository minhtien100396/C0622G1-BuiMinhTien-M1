package kiem_tra.utils.validate.nhap_thong_tin_cho_hoc_vien;

import case_study.task_1.utils.exception.DateException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class NhapNgayNhapHoc {
    private static Scanner scanner = new Scanner(System.in);

    public static String nhapNgayNhapHoc() {
        String dateOfBirth;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDay;
        int age;
        while (true) {
            try {
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Mời bạn nhập vào ngày nhập học (dd/MM/yyyy)");
                dateOfBirth = scanner.nextLine();
                birthDay = LocalDate.parse(dateOfBirth, dateTimeFormatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Vui lòng nhập đúng định dạng dd/MM/yyyy");
            }
        }
        return dateOfBirth;
    }
}
