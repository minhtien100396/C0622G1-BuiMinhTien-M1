package ss18_string_and_regex.bai_tap.bai_1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ClassNameRegex {
    private  static  final  String NAME_CLASS_REGEX = "^C|A|P[0-9]{4}[G|H|I|K|L|M]$";
    //private static  final String NAME_REGEX = "^[A-Za-z ]{5,50}$";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Mời bạn nhập vào tên của lớp học");
            String nameClass = scanner.nextLine();
            if (nameClass.matches(NAME_CLASS_REGEX)){
                System.out.println("Tên lớp hợp lệ");
                break;
            }else {
                System.out.println("Tên lớp không hợp lệ. Vui lòng nhập lại");
            }
        }

    }
}
