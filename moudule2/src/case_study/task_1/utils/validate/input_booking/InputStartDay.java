package case_study.task_1.utils.validate.input_booking;

import case_study.task_1.utils.exception.DateException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class InputStartDay {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputStartDay() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
        String startD;
        LocalDate startDay;
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào ngày bắt đầu (dd/MM/yyyy)");
                startD = scanner.nextLine();
                startDay = LocalDate.parse(startD,dateTimeFormatter);
                LocalDate dateNow = LocalDate.now();
                if (startDay.isBefore(dateNow)) {
                    throw new DateException("Ngày bắt đầu không thể nhỏ hơn ngày hiện tại");
                } else {
                    break;
                }
            } catch (DateException e) {
                System.out.println(e.getMessage());
            } catch (DateTimeParseException e) {
                System.out.println("Vui lòng nhập đúng định dạng dd/MM/yyyy");
            }
        }
        return startD;
    }

}
