package case_study.task_1.utils.validate.input_booking;

import case_study.task_1.models.Customer;
import case_study.task_1.utils.exception.DuplicatePersomnalRecordException;
import case_study.task_1.utils.read_and_write.ReadFileUtils;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class InputIdCustomer {
    private static Scanner scanner = new Scanner(System.in);
    private static String ID_REGEX = "^MSKH 0?[1-9]+[0-9]*$";


    public static String inputIdCustomer() throws IOException {
        String id;
        boolean check;
        List<Customer> customerList = ReadFileUtils.readFileCustomer("src\\case_study\\task_1\\data\\customer.csv");
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào Mã số Khách Hàng (MSKH XXXXX)");
                id = scanner.nextLine();
                check = false;
                for (Customer customer : customerList) {
                    if ((customer.getIdCustomer().equals(id))) {
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    throw new DuplicatePersomnalRecordException("ID bạn nhập không có trong danh sách Khách Hàng. Vui lòng nhập lại");
                }
                if (id.matches(ID_REGEX)) {
                    break;
                } else {
                    throw new DuplicatePersomnalRecordException("ID không hợp lệ. Hãy kiểm tra lại!");
                }
            } catch (DuplicatePersomnalRecordException e) {
                System.out.println(e.getMessage());
            }
        }
        return id;
    }
}
