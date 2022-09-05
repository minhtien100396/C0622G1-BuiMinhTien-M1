package case_study.task_1.utils.validate.input_employee;

import case_study.task_1.models.Customer;
import case_study.task_1.models.Employee;
import case_study.task_1.services.impl.EmployeeServiceImpl;
import case_study.task_1.utils.exception.IdException;
import case_study.task_1.utils.read_and_write.ReadFileUtils;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class InputIdEmployeeUltils {
    private static Scanner scanner = new Scanner(System.in);
    private static String ID_REGEX = "^(MSNV) 0?[1-9]+[0-9]*$";


    public static String inputIdEmployee() throws IOException {
        String id;
        List<Employee> employeeList = ReadFileUtils.readFileEmployee("src\\case_study\\task_1\\data\\employee.csv");

        while (true) {
            try {
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Mời bạn nhập vào Mã số Nhân viên (MSNV XXXXX)");
                id = scanner.nextLine();
                for (Employee employee : employeeList) {
                    if (employee.getIdEmployee().equals(id)) {
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
