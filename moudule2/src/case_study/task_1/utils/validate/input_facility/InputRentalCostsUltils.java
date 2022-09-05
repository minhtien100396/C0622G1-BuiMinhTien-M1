package case_study.task_1.utils.validate.input_facility;

import case_study.task_1.utils.exception.SalaryException;

import java.util.Scanner;

public class InputRentalCostsUltils {
    private static Scanner scanner = new Scanner(System.in);

    public static double inputRentalCostsUltils() {
        double rentalCosts;
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào chi phí thuê:");
                rentalCosts = Double.parseDouble(scanner.nextLine());
                if (rentalCosts <= 0) {
                    throw new SalaryException("Chi phí thuê phải là số dương. Hãy kiểm tra lại!");
                }
                break;
            } catch (SalaryException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Chi phí thuê phải là một chữ số!. Vui lòng nhập lại");
            }
        }
        return rentalCosts;
    }
}
