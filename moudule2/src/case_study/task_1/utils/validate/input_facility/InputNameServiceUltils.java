package case_study.task_1.utils.validate.input_facility;

import case_study.task_1.utils.exception.ChoiceException;

import java.util.Scanner;

public class InputNameServiceUltils {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputNameServiceUltils() {
        int choice;
        String nameService;
        while (true) {
            try {
                System.out.println("Mời bạn lựa chọn loại hình dịch vụ:");
                System.out.println("1. Villa");
                System.out.println("2. House");
                System.out.println("3. Room");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 3) {
                    throw new ChoiceException("Lựa chọn của bạn không hợp lê!. Hãy kiểm tra lại");
                } else {
                    switch (choice) {
                        case 1:
                            nameService = "Villa";
                            return nameService;
                        case 2:
                            nameService = "House";
                            return nameService;
                        case 3:
                            nameService = "Room";
                            return nameService;
                    }
                }
            } catch (ChoiceException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập vào lựa chọn chính xác (1->3)");
            }
        }
    }
}
