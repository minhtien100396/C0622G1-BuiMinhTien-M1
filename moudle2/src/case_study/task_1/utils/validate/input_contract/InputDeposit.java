package case_study.task_1.utils.validate.input_contract;

import case_study.task_1.utils.exception.SalaryException;

import java.util.Scanner;

public class InputDeposit {
    private static Scanner scanner = new Scanner(System.in);

    public static double inputDeposit() {
        double deposit;
        while (true) {
            try {
                System.out.println("------------------------------------------------------------");
                System.out.println("Mời bạn nhập vào tiền cọc: ");
                deposit = Double.parseDouble(scanner.nextLine());
                if (deposit <= 0) {
                    throw new SalaryException("Tiền cọc không hợp lệ!. Hãy kiểm tra lại (tiền cọc>0)");
                }
                break;
            } catch (SalaryException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Tiền cọc phải là một chữ số!. Vui lòng nhập lại");
            }
        }
        return deposit;
    }
}
