package case_study.task_1.utils.validate.input_villa;

import case_study.task_1.utils.exception.SalaryException;

import java.util.Scanner;

public class InputPoolAreaUltils {
    private static Scanner scanner = new Scanner(System.in);

    public static double inputPoolAreaUltils() {
        double poolArea;
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào diện tích hồ bơi:");
                poolArea = Double.parseDouble(scanner.nextLine());
                if (poolArea <= 30) {
                    throw new SalaryException("Diện tích hồ bơi không hợp lệ!. Hãy kiểm tra lại (S>30)");
                }
                break;
            } catch (SalaryException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e){
                System.out.println("Diện tích hồ bơi phải là một chữ số!. Vui lòng nhập lại");
            }
        }
        return poolArea;
    }
}
