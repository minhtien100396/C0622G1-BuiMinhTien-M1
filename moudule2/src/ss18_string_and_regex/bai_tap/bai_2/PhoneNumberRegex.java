package ss18_string_and_regex.bai_tap.bai_2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneNumberRegex {
    private  static  final  String PHONE_NUMBER_REGEX = "^[(][0-9]{2}[)]-[(]0[0-9]{9}[)]$";
    private  static  final  String PHONE_NUMBER_REGEX1 = "[0-9]{3}\\.[0-9]{3}\\.[0-9]{4}";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Mời bạn nhập vào số điện thoại");
            String phoneNumber = scanner.nextLine();
            if (phoneNumber.matches(PHONE_NUMBER_REGEX1)){
                System.out.println("Số điện thoại hợp lệ");
                break;
            }else {
                System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại");
            }
        }

    }
}
