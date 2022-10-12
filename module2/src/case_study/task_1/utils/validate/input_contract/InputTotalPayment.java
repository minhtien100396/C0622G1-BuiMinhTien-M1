package case_study.task_1.utils.validate.input_contract;

import case_study.task_1.utils.exception.SalaryException;

import java.util.Scanner;

public class InputTotalPayment {
    private static Scanner scanner = new Scanner(System.in);

    public static double inputTotalPayment() {
        double totalPayment;
        while (true) {
            try {
                System.out.println("------------------------------------------------------------");
                System.out.println("Mời bạn nhập vào tổng tiền thanh toán: ");
                totalPayment = Double.parseDouble(scanner.nextLine());
                if (totalPayment <= 0) {
                    throw new SalaryException("Tổng tiền thanh toán không hợp lệ!. Hãy kiểm tra lại (Tổng tiền thanh toán >0)");
                }
                break;
            } catch (SalaryException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Tổng tiền thanh toán phải là một chữ số!. Vui lòng nhập lại");
            }
        }
        return totalPayment;
    }
}
