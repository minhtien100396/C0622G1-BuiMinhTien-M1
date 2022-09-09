package case_study.task_1.utils.validate.input_booking;

import case_study.task_1.models.Booking;
import case_study.task_1.utils.InputBooking;
import case_study.task_1.utils.exception.DateException;
import case_study.task_1.utils.read_and_write.ReadFileUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;
import java.util.Set;

public class InputStartDay {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputStartDay() throws IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
        String startD;
        LocalDate startDay;
        LocalDate dateNow;
        Set<Booking> bookingSet = ReadFileUtils.readFileBooking("src\\case_study\\task_1\\data\\booking.csv");
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào ngày bắt đầu (dd/MM/yyyy)");
                startD = scanner.nextLine();
                startDay = LocalDate.parse(startD, dateTimeFormatter);
                dateNow = LocalDate.now();
                if (startDay.isBefore(dateNow)) {
                    throw new DateException("Ngày bắt đầu không thể nhỏ hơn ngày hiện tại");
                }
                for (Booking booking : bookingSet) {
                    if (booking.getIdService().equals(InputBooking.getIdService())) {
                        if (startDay.isAfter(LocalDate.parse(booking.getStartDay(), DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT))) &&
                                startDay.isBefore(LocalDate.parse(booking.getEndDay(), DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT)))) {
                            throw new DateException("Ngày bạn nhập đã được Booking");
                        } else if (startDay.isEqual(LocalDate.parse(booking.getStartDay(), DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT))) ||
                                startDay.isEqual(LocalDate.parse(booking.getEndDay(), DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT)))) {
                            throw new DateException("Ngày bạn nhập đã được Booking");
                        }
                    }
                }
                break;
            } catch (DateException e) {
                System.out.println(e.getMessage());
            } catch (DateTimeParseException e) {
                System.out.println("Vui lòng nhập đúng định dạng dd/MM/yyyy");
            }
        }
        return startD;
    }

}
