package case_study.task_1.utils.validate.input_person;

import case_study.task_1.utils.exception.ChoiceException;

import java.util.Scanner;

public class InputGenderUltils {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputGender() {
        int choice;
        String gender;
        while (true) {
            try {
                System.out.println("-------------------------------------------------------");
                System.out.println("Mời bạn lựa chọn giới tính của nhân viên:");
                System.out.println("1. Nam");
                System.out.println("2. Nữ");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 2) {
                    throw new ChoiceException("Lựa chọn của bạn không hợp lê!. Hãy kiểm tra lại");
                } else {
                    switch (choice) {
                        case 1:
                            gender = "Nam";
                            return gender;
                        case 2:
                            gender = "Nữ";
                            return gender;
                    }
                }
            } catch (ChoiceException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập vào lựa chọn chính xác (1->2)");
            }
        }
    }
}
