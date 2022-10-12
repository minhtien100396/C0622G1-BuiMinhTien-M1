package ss18_string_and_regex.thuc_hanh.bai_1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class EmailExample {
    private static final String EMAIL_REGEX = "^[[A-Za-z]+[0-9]*]{5,30}@[a-z]+(\\.[a-z]+)$";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Mời bạn nhập vào địa chỉ Email: ");
            String email = scanner.nextLine();
//        System.out.println(email);
            //Tham số truyền vào trong compile là chuỗi  Regex
            //bắt đầu bằng ^ và kết thúc bằng $
            Pattern pattern = Pattern.compile(EMAIL_REGEX);
            if (pattern.matcher(email).find()) {
                System.out.println("Email bạn nhập hợp lệ");
                break;
            } else {
                System.out.println("Email không hợp lệ");
            }
        }

    }
}
