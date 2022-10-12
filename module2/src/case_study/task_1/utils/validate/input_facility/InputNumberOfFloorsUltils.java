package case_study.task_1.utils.validate.input_facility;

import case_study.task_1.utils.exception.SalaryException;

import java.util.Scanner;

public class InputNumberOfFloorsUltils {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputNumberOfFloorsUltils() {
        int numberOfFloors;
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào số tầng:");
                numberOfFloors = Integer.parseInt(scanner.nextLine());
                if (numberOfFloors <= 0) {
                    throw new SalaryException("Số tầng không hợp lệ!. Hãy kiểm tra lại");
                }
                break;
            } catch (SalaryException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e){
                System.out.println("Số tầng phải là một chữ số!. Vui lòng nhập lại");
            }
        }
        return numberOfFloors;
    }
}
