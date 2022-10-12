package ss18_string_and_regex.thuc_hanh.bai_2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class AccountExample {
    private static final String ACCOUT_REGEX = "^[a-z0-9_]{6,}$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Mời bạn nhập vào tên tài khoản");
            String name = scanner.nextLine();
            Pattern pattern = Pattern.compile(ACCOUT_REGEX);
            if (pattern.matcher(name).find()) {
                System.out.println("Tên bạn nhập hợp lệ");
                break;
            } else {
                System.out.println("Tên bạn nhập không hợp lệ. Hãy kiểm tra lại");
            }
        }

    }
}
