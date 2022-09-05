package case_study.task_1.utils.validate.input_booking;

import case_study.task_1.utils.exception.DateException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Comparator;
import java.util.Scanner;

public class InputEndDay {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputEndDay(String starDay) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
        LocalDate starDayCheck = LocalDate.parse(starDay,dateTimeFormatter);
        String endD;
        LocalDate endDay;
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào ngày kết thúc (dd/MM/yyyy)");
                endD = scanner.nextLine();
                endDay = LocalDate.parse(endD, dateTimeFormatter);
                if (endDay.isBefore(starDayCheck)) {
                    throw new DateException("Ngày kết thúc không thể nhỏ hơn ngày bắt đầu");
                } else {
                    break;
                }
            } catch (DateException e) {
                System.out.println(e.getMessage());
            } catch (DateTimeParseException e) {
                System.out.println("Vui lòng nhập đúng định dạng dd/MM/yyyy");
            }
        }
        return endD;
    }
}
