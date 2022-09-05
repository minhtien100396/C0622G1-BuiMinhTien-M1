package case_study.task_1.utils.validate.input_facility;

import case_study.task_1.utils.exception.SalaryException;

import java.util.Scanner;

public class InputUsableAreaUltils {
    private static Scanner scanner = new Scanner(System.in);

    public static double inputUsableAreaUltils() {
        double usableArea;
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào diện tích muốn sử dụng:");
                usableArea = Double.parseDouble(scanner.nextLine());
                if (usableArea <= 30) {
                    throw new SalaryException("Diện tích sử dụng không hợp lệ. Hãy kiểm tra lại!(S>30)");
                }
                break;
            } catch (SalaryException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Diện tích phải là một chữ số!. Vui lòng nhập lại");
            }
        }
        return usableArea;
    }
}
