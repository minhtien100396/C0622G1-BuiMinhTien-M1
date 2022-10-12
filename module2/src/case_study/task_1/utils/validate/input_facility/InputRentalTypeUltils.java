package case_study.task_1.utils.validate.input_facility;

import case_study.task_1.utils.exception.ChoiceException;

import java.util.Scanner;

public class InputRentalTypeUltils {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputRentalTypeUltils() {
        int choice;
        String rentalType;
        while (true) {
            try {
                System.out.println("Mời bạn lựa chọn kiểu muốn thuê phòng:");
                System.out.println("1. Thuê theo năm");
                System.out.println("2. Thuê theo tháng");
                System.out.println("3. Thuê theo ngày");
                System.out.println("4. Thuê theo giờ");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 4) {
                    throw new ChoiceException("Lựa chọn của bạn không hợp lê!. Hãy kiểm tra lại");
                } else {
                    switch (choice) {
                        case 1:
                            rentalType = "Thuê theo năm";
                            return rentalType;
                        case 2:
                            rentalType = "Thuê theo tháng";
                            return rentalType;
                        case 3:
                            rentalType = "Thuê theo ngày";
                            return rentalType;
                        case 4:
                            rentalType = "Thuê theo giờ";
                            return rentalType;
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
