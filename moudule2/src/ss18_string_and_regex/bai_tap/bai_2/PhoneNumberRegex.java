package ss18_string_and_regex.bai_tap.bai_2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneNumberRegex {
    private  static  final  String PHONE_NUMBER_REGEX = "^[(][0-9]{2}[)]-[(]0[0-9]{9}[)]$";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Mời bạn nhập vào số điện thoại");
            String phoneNumber = scanner.nextLine();
            if (phoneNumber.matches(PHONE_NUMBER_REGEX)){
                System.out.println("Tên lớp hợp lệ");
                break;
            }else {
                System.out.println("Tên lớp không hợp lệ. Vui lòng nhập lại");
            }
        }

    }
}
