package case_study.task_1.utils.validate.input_employee;

import case_study.task_1.utils.exception.ChoiceException;

import java.util.Scanner;

public class InputPositionOfEmployeeUltils {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputPositionOfEmployeeUltils() {
        int choice;
        String position;
        while (true) {
            try {
                System.out.println("------------------------------------------------------");
                System.out.println("Mời bạn lựa chọn vị trí của nhân viên:");
                System.out.println("1. Lễ tân");
                System.out.println("2. Phục vụ");
                System.out.println("3. Chuyên viên");
                System.out.println("4. Giám sát");
                System.out.println("5. Quản lý");
                System.out.println("6. Giám đốc");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 6) {
                    throw new ChoiceException("Lựa chọn của bạn không hợp lê!. Hãy kiểm tra lại");
                } else {
                    switch (choice) {
                        case 1:
                            position = "Lễ tân";
                            return position;
                        case 2:
                            position = "Phục vụ";
                            return position;
                        case 3:
                            position = "Chuyên viên";
                            return position;
                        case 4:
                            position = "Giám Sát";
                            return position;
                        case 5:
                            position = "Quản lý";
                            return position;
                        case 6:
                            position = "Giám Đốc";
                            return position;
                    }
                }
            } catch (ChoiceException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e){
                System.out.println("Vui lòng nhập vào lựa chọn chính xác (1->6)");
            }
        }
    }
}
