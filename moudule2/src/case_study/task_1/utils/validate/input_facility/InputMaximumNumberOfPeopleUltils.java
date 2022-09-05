package case_study.task_1.utils.validate.input_facility;

import case_study.task_1.utils.exception.SalaryException;

import java.util.Scanner;

public class InputMaximumNumberOfPeopleUltils {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputMaximumNumberOfPeopleUltils() {
        int maximumNumberOfPeople;
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào số lượng người tối đa:");
                maximumNumberOfPeople = Integer.parseInt(scanner.nextLine());
                if (maximumNumberOfPeople <= 0 || maximumNumberOfPeople > 20) {
                    throw new SalaryException("Số lượng người không hợp lệ. Hãy kiểm tra lại! (1-20)");
                }
                break;
            } catch (SalaryException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Số lượng người phải là một chữ số!. Vui lòng nhập lại");
            }
        }
        return maximumNumberOfPeople;
    }
}
