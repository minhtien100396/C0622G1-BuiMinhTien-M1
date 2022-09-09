package kiem_tra.utils.validate.nhap_thong_tin_nhan_su;

import case_study.task_1.utils.exception.PhoneNumberException;

import java.util.Scanner;

public class NhapSoDienThoai {
    private static Scanner scanner = new Scanner(System.in);
    private static final String PHONE_NUMBER_REGEX = "^[(][0-9]{2}[)]-[(]0[0-9]{9}[)]$";

    public static String nhapSoDienThoai() {
        String phoneNumber;
        while (true) {
            try {
                System.out.println("--------------------------------------------------------");
                System.out.println("Mời bạn nhập vào số điện thoại (XX)-(0XXXXXXXXX)");
                phoneNumber = scanner.nextLine();
                if (phoneNumber.matches(PHONE_NUMBER_REGEX)) {
                    break;
                } else {
                    throw new PhoneNumberException("Số Điện Thoại bạn nhập không hợp lê!. Hãy kiểm tra lại! (XX)-(0XXXXXXXXX)");
                }
            } catch (PhoneNumberException e) {
                System.out.println(e.getMessage());
            }

        }
        return phoneNumber;
    }
}
