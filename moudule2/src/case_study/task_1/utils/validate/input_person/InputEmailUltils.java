package case_study.task_1.utils.validate.input_person;

import case_study.task_1.utils.exception.EmailException;

import java.util.Scanner;

public class InputEmailUltils {
    private static Scanner scanner = new Scanner(System.in);
    private static final String EMAIL_REGEX = "^[[A-Za-z]+[0-9]*]{5,30}@[a-z]+(\\.[a-z]+)$";

    public static String inputEmail() {
        String email;
        while (true) {
            try {
                System.out.println("-----------------------------------------------");
                System.out.println("Mời bạn nhập vào email (XXXXX@XX.XX)");
                email = scanner.nextLine();
                if (email.matches(EMAIL_REGEX)){
                    break;
                }else {
                    throw new EmailException("Email bạn nhập không hợp lệ. Hãy kiểm tra lại (XXXXX@XX.XX)");
                }
            }catch (EmailException e){
                System.out.println(e.getMessage());
            }
        }

        return email;
    }
}
