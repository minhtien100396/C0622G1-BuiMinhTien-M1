package case_study.task_1.utils.validate.input_room;

import case_study.task_1.utils.exception.ChoiceException;

import java.util.Scanner;

public class InputFreeServiceIncludedUltils {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputFreeServiceIncludedUltils() {
        int choice;
        String inputFreeServiceIncluded;
        while (true) {
            try {
                System.out.println("Mời bạn lựa chọn dịch vụ cần cung cấp miễn phí");
                System.out.println("1. Đồ sạc pin điện thoại");
                System.out.println("2. Máy sấy tóc");
                System.out.println("3. Dụng cụ làm tóc");
                System.out.println("4. Bàn là");
                System.out.println("5. Đồ chơi trẻ em");
                System.out.println("6. Ô");
                System.out.println("7. Chăn gối thêm");
                System.out.println("8. Nước suối-trà túi lọc và cà phê");
                System.out.println("9. Bộ kim chỉ may vá");
                System.out.println("10. Khăn tắm-áo choàng và ghế tắm nắng");
                System.out.println("11. Các loại sách hướng dẫn du lịch-brochure và bản đồ");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 11) {
                    throw new ChoiceException("Lựa chọn của bạn không hợp lê!. Hãy kiểm tra lại");
                } else {
                    switch (choice) {
                        case 1:
                            inputFreeServiceIncluded = "Đồ sạc pin điện thoại";
                            return inputFreeServiceIncluded;
                        case 2:
                            inputFreeServiceIncluded = "Máy sấy tóc";
                            return inputFreeServiceIncluded;
                        case 3:
                            inputFreeServiceIncluded = "Dụng cụ làm tóc";
                            return inputFreeServiceIncluded;
                        case 4:
                            inputFreeServiceIncluded = "Bàn là";
                            return inputFreeServiceIncluded;
                        case 5:
                            inputFreeServiceIncluded = "Đồ chơi trẻ em";
                            return inputFreeServiceIncluded;
                        case 6:
                            inputFreeServiceIncluded = "Ô";
                            return inputFreeServiceIncluded;
                        case 7:
                            inputFreeServiceIncluded = "Chăn gối thêm";
                            return inputFreeServiceIncluded;
                        case 8:
                            inputFreeServiceIncluded = "Nước suối, trà túi lọc và cà phê";
                            return inputFreeServiceIncluded;
                        case 9:
                            inputFreeServiceIncluded = "Bộ kim chỉ may vá";
                            return inputFreeServiceIncluded;
                        case 10:
                            inputFreeServiceIncluded = "Khăn tắm, áo choàng và ghế tắm nắng";
                            return inputFreeServiceIncluded;
                        case 11:
                            inputFreeServiceIncluded = "Các loại sách hướng dẫn du lịch, brochure và bản đồ";
                            return inputFreeServiceIncluded;
                    }
                }
            } catch (ChoiceException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e){
                System.out.println("Vui lòng nhập vào lựa chọn chính xác (1->11)");
            }
        }
    }
}
