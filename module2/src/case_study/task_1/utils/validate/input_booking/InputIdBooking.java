package case_study.task_1.utils.validate.input_booking;

import case_study.task_1.models.Booking;
import case_study.task_1.utils.exception.DuplicatePersomnalRecordException;
import case_study.task_1.utils.read_and_write.ReadFileUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class InputIdBooking {
    private static Scanner scanner = new Scanner(System.in);
    private static String ID_REGEX = "^MSBK\\-[0-9]{1,5}$";


    public static String inputId() throws IOException {
        Set<Booking> bookingSet = ReadFileUtils.readFileBooking("src\\case_study\\task_1\\data\\booking.csv");
        String id;
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào Mã số Booking (MSBK-YYYYY)");
                id = scanner.nextLine();
                for (Booking booking : bookingSet) {
                    if (booking.getIdBooking().equals(id)){
                        throw new DuplicatePersomnalRecordException("ID bạn nhập đã tồn tại!. Vui lòng nhập lại");
                    }
                }
                if (id.matches(ID_REGEX)) {
                    break;
                } else {
                    throw new DuplicatePersomnalRecordException("Mã Booking không hợp lệ. Hãy kiểm tra lại! (MSBK-YYYY)");
                }
            } catch (DuplicatePersomnalRecordException e) {
                System.out.println(e.getMessage());
            }
        }
        return id;
    }
}
