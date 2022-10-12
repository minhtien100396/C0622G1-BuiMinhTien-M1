package case_study.task_1.utils.validate.input_person;

import case_study.task_1.utils.exception.IdNumberException;

import java.util.Scanner;

public class InputIdCardUltils {
    private static Scanner scanner = new Scanner(System.in);
    private static String ID_CARD_REGEX = "^[0-9]{9}$";

    public static String inputIdCard() {
        String idCard;
        while (true) {
            try {
                System.out.println("---------------------------------------------------");
                System.out.println("Mời bạn nhập vào số chứng minh nhân dân (9 số) ");
                idCard = scanner.nextLine();
                if (idCard.matches(ID_CARD_REGEX)) {
                    break;
                } else {
                    throw new IdNumberException("Số chứng minh nhân dân không hợp lệ! Hãy kiểm tra lại (9 số)");
                }
            } catch (IdNumberException e) {
                System.out.println(e.getMessage());
            }
        }

        return idCard;
    }
}
