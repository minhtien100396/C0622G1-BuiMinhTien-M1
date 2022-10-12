package kiem_tra.utils.validate.nhap_thong_tin_cho_hoc_vien;

import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.utils.exception.ClassNameException;
import case_study.task_1.utils.exception.ChoiceException;

import java.util.Scanner;

public class NhapTenLop {
    private static Scanner scanner = new Scanner(System.in);
    private static final String TEN_LOP_REGEX = "(A|C)[0-9]{4}(G|I)[1]";

    public static String nhapTenLop() {
        String className;
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào tên lớp ");
                className = scanner.nextLine();
                if (className.matches(TEN_LOP_REGEX)) {
                    return className;
                } else {
                    throw new ClassNameException("Tên lớp không hợp lệ");
                }
            } catch (ClassNameException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
