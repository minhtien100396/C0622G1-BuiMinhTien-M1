package case_study.task_1.utils.validate.input_person;

import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.utils.exception.NameException;

import java.util.Scanner;

public class InputNameUltils {
    private static Scanner scanner = new Scanner(System.in);
    private static final String NAME_REGEX = "^[A-Za-zvxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ ]{5,50}$";

    public static String inputName() {
        String name;
        while (true) {
            try {
                System.out.println("-------------------------------------------------------");
                System.out.println("Mời bạn nhập họ và tên: (chỉ chứa 5-50 kí tự)");
                name = scanner.nextLine();
                if (name.matches(NAME_REGEX)) {
                    break;
                } else {
                    throw new NameException("Họ và Tên không hợp lệ!. Hãy kiểm tra lại (chỉ chứa 5-50 kí tự)");
                }
            } catch (NameException e) {
                System.out.println(e.getMessage());
            }
        }

        return name;
    }
}
