package case_study.task_1.utils.validate.input_employee;

import case_study.task_1.utils.exception.ChoiceException;

import java.util.Scanner;

public class InputLevelOfEmployeeUltils {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputLevelOfEmployeeUltils() {
        int choice;
        String level;
        while (true) {
            try {
                System.out.println("--------------------------------------------------------------");
                System.out.println("Mời bạn lựa chọn trình độ của nhân viên:");
                System.out.println("1. Trung cấp");
                System.out.println("2. Cao đẳng");
                System.out.println("3. Đại học");
                System.out.println("4. Sau đại học");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 4) {
                    throw new ChoiceException("Lựa chọn của bạn không hợp lê!. Hãy kiểm tra lại");
                } else {
                    switch (choice) {
                        case 1:
                            level = "Trung cấp";
                            return level;
                        case 2:
                            level = "Cao đẳng";
                            return level;
                        case 3:
                            level = "Đại học";
                            return level;
                        case 4:
                            level = "Sau đại học";
                            return level;
                    }
                }
            } catch (ChoiceException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e){
                System.out.println("Vui lòng nhập vào lựa chọn chính xác (1->4)");
            }
        }
    }
}
