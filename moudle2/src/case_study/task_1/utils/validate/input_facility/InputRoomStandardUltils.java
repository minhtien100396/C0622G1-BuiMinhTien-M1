package case_study.task_1.utils.validate.input_facility;

import case_study.task_1.utils.exception.ChoiceException;

import java.util.Scanner;

public class InputRoomStandardUltils {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputRoomStandardUltils() {
        int choice;
        String roomStandard;
        while (true) {
            try {
                System.out.println("Mời bạn lựa chọn tiêu chuẩn phòng:");
                System.out.println("1. Cao cấp");
                System.out.println("2. Phổ thông");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 2) {
                    throw new ChoiceException("Lựa chọn của bạn không hợp lê!. Hãy kiểm tra lại");
                } else {
                    switch (choice) {
                        case 1:
                            roomStandard = "Cao cấp";
                            return roomStandard;
                        case 2:
                            roomStandard = "Phổ thông";
                            return roomStandard;
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
