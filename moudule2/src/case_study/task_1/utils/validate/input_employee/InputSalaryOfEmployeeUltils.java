package case_study.task_1.utils.validate.input_employee;

import case_study.task_1.utils.exception.SalaryException;

import java.util.Scanner;

public class InputSalaryOfEmployeeUltils {
    private static Scanner scanner = new Scanner(System.in);

    public static double inputSalaryOfEmployeeUltils() {
        double salary;
        while (true) {
            try {
                System.out.println("------------------------------------------------------------");
                System.out.println("Mời bạn nhập vào lương của nhân viên:");
                salary = Double.parseDouble(scanner.nextLine());
                if (salary <= 0) {
                    throw new SalaryException("Lương của nhân viên không hợp lệ!. Hãy kiểm tra lại (lương>0)");
                }
                break;
            } catch (SalaryException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e){
                System.out.println("Lương phải là một chữ số!. Vui lòng nhập lại");
            }
        }
        return salary;
    }
}
