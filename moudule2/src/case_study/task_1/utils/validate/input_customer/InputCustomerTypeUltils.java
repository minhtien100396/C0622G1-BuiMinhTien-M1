package case_study.task_1.utils.validate.input_customer;

import case_study.task_1.utils.exception.ChoiceException;

import java.util.Scanner;

public class InputCustomerTypeUltils {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputCustomerTypeUltils() {
        int choice;
        String customerType;
        while (true) {
            try {
                System.out.println("Mời bạn lựa chọn loại Khách Hàng:");
                System.out.println("1. Diamond");
                System.out.println("2. Platinium");
                System.out.println("3. Gold");
                System.out.println("4. Silver");
                System.out.println("5. Member");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 5) {
                    throw new ChoiceException("Lựa chọn của bạn không hợp lê!. Hãy kiểm tra lại");
                } else {
                    switch (choice) {
                        case 1:
                            customerType = "Diamond";
                            return customerType;
                        case 2:
                            customerType = "Platinium";
                            return customerType;
                        case 3:
                            customerType = "Gold";
                            return customerType;
                        case 4:
                            customerType = "Silver";
                            return customerType;
                        case 5:
                            customerType = "Member";
                            return customerType;
                    }
                }
            } catch (ChoiceException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập vào lựa chọn chính xác (1->5)");
            }
        }
    }
}

