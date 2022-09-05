package case_study.task_1.utils.validate.input_customer;

import case_study.task_1.models.Customer;
import case_study.task_1.services.impl.CustomerServiceImpl;
import case_study.task_1.utils.exception.IdException;
import case_study.task_1.utils.read_and_write.ReadFileUtils;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class InputIdCustomerUltils {
    private static Scanner scanner = new Scanner(System.in);
    private static String ID_REGEX = "^MSKH 0?[1-9]+[0-9]*$";


    public static String inputIdCustomer() throws IOException {
        String id;
        List<Customer> customerList = ReadFileUtils.readFileCustomer("src\\case_study\\task_1\\data\\customer.csv");
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào Mã số Khách Hàng (MSKH XXXXX)");
                id = scanner.nextLine();
                for (Customer customer : customerList) {
                    if (customer.getIdCustomer().equals(id)) {
                        throw new IdException("ID bạn nhập đã tồn tại!. Vui lòng nhập lại");
                    }
                }
                if (id.matches(ID_REGEX)) {
                    break;
                } else {
                    throw new IdException("ID không hợp lệ. Hãy kiểm tra lại!");
                }
            } catch (IdException e) {
                System.out.println(e.getMessage());
            }
        }
        return id;
    }
}
