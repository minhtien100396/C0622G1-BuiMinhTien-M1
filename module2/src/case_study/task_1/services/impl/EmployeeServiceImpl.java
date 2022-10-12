package case_study.task_1.services.impl;

import case_study.task_1.models.Employee;
import case_study.task_1.services.IEmployeeService;
import case_study.task_1.utils.InputEmployee;
import case_study.task_1.utils.read_and_write.ReadFileUtils;
import case_study.task_1.utils.read_and_write.WriteFileUtils;
import case_study.task_1.utils.validate.input_employee.InputLevelOfEmployeeUltils;
import case_study.task_1.utils.validate.input_employee.InputPositionOfEmployeeUltils;
import case_study.task_1.utils.validate.input_employee.InputSalaryOfEmployeeUltils;
import case_study.task_1.utils.validate.input_person.*;

import java.io.IOException;
import java.util.*;

public class EmployeeServiceImpl implements IEmployeeService {
    private Scanner scanner = new Scanner(System.in);
    private static List<Employee> employeeList = new ArrayList<>();
    private final String EMPLOYEE_FILE = "src\\case_study\\task_1\\data\\employee.csv";

    @Override
    public void addEmployee() throws IOException {
        employeeList = ReadFileUtils.readFileEmployee(EMPLOYEE_FILE);
        Employee employee = this.infoEmployee();
        employeeList.add(employee);
        System.out.println("Bạn đã thêm thành công");
        WriteFileUtils.writeFileEmployee(EMPLOYEE_FILE, employeeList);
    }

    @Override
    public void displayListEmployee() throws IOException {
        employeeList = ReadFileUtils.readFileEmployee(EMPLOYEE_FILE);
        if (employeeList.isEmpty()) {
            System.out.println("Không có bất kì thông tin nhân viên nào trong danh sách");
        } else {
            System.out.println("------------------DANH SÁCH NHÂN VIÊN------------------");
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        }
    }

    @Override
    public void editEmployee() throws IOException {
        employeeList = ReadFileUtils.readFileEmployee(EMPLOYEE_FILE);
        String id;
        int choice;
        boolean check = false;
        displayListEmployee();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Mời bạn nhập vào Mã Số Nhân Viên muốn chỉnh sửa (MSNV XXXXX)");
        id = scanner.nextLine();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getIdEmployee().equals(id)) {
                System.out.println("Bạn có chắc chắn muốn thay đổi thông tin nhân viên có ID là " + employeeList.get(i).getIdEmployee() + " không?");
                System.out.println("1. Có");
                System.out.println("2. Không");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    employeeList.get(i).setName(InputNameUltils.inputName());
                    employeeList.get(i).setDateOfBirth(InputDateOfBirthUltils.inputDateOfBirth());
                    employeeList.get(i).setGender(InputGenderUltils.inputGender());
                    employeeList.get(i).setIdCard(InputIdCardUltils.inputIdCard());
                    employeeList.get(i).setPhoneNumber(InputPhoneNumberUltils.inputPhoneNumber());
                    employeeList.get(i).setEmail(InputEmailUltils.inputEmail());
                    employeeList.get(i).setLevel(InputLevelOfEmployeeUltils.inputLevelOfEmployeeUltils());
                    employeeList.get(i).setPosition(InputPositionOfEmployeeUltils.inputPositionOfEmployeeUltils());
                    employeeList.get(i).setSalary(InputSalaryOfEmployeeUltils.inputSalaryOfEmployeeUltils());
                    System.out.println("Bạn đã chỉnh sửa thành công");
                    WriteFileUtils.writeFileEmployee(EMPLOYEE_FILE, employeeList);
                    check = true;
                    break;
                } else if (choice == 2) {
                    return;
                }
            }
        }
        if (!check) {
            System.out.println("ID bạn nhập không tồn tại. Vui lòng kiểm tra lại!");
        }
    }

    @Override
    public void deleteEmployee() throws IOException {
        employeeList = ReadFileUtils.readFileEmployee(EMPLOYEE_FILE);
        String id;
        int choice;
        boolean check = false;
        displayListEmployee();
        if (employeeList.isEmpty()) {
            System.out.println("Danh sách hiện tại không có nhân viên nào. Hãy thêm nhân viên mới xóa được");
        } else {
            while (true) {
                System.out.println("------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Mời bạn nhập vào Mã Số Nhân Viên muốn xóa khỏi danh sách (MSNV XXXXX)");
                id = scanner.nextLine();
                for (int i = 0; i < employeeList.size(); i++) {
                    if (employeeList.get(i).getIdEmployee().equals(id)) {
                        System.out.println("Bạn có chắc chắn muốn xóa thông tin nhân viên có ID là " + employeeList.get(i).getIdEmployee() + " không?");
                        System.out.println("1. Có");
                        System.out.println("2. Không");
                        choice = Integer.parseInt(scanner.nextLine());
                        if (choice == 1) {
                            employeeList.remove(i);
                            System.out.println("Bạn đã xóa thành công");
                            WriteFileUtils.writeFileEmployee(EMPLOYEE_FILE, employeeList);
                            check = true;
                            return;
                        } else if (choice == 2) {
                            return;
                        }
                    }
                }
                if (!check) {
                    System.out.println("ID bạn nhập không tồn tại. Vui lòng kiểm tra lại!");
                }
            }
        }

    }

    @Override
    public void sortName() throws IOException {
        employeeList = ReadFileUtils.readFileEmployee(EMPLOYEE_FILE);
        Collections.sort(employeeList);
        WriteFileUtils.writeFileEmployee(EMPLOYEE_FILE, employeeList);
        displayListEmployee();
    }

    @Override
    public void sortSalary() throws IOException {
        employeeList = ReadFileUtils.readFileEmployee(EMPLOYEE_FILE);
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getSalary() - o2.getSalary());
            }
        };
        Collections.sort(employeeList, comparator);
        WriteFileUtils.writeFileEmployee(EMPLOYEE_FILE, employeeList);
        displayListEmployee();
    }

    @Override
    public void searchIdEmployee() throws IOException {
        employeeList = ReadFileUtils.readFileEmployee(EMPLOYEE_FILE);
        String id;
        int choice;
        boolean check = false;
        displayListEmployee();
        if (employeeList.isEmpty()) {
            System.out.println("Danh sách hiện tại không có nhân viên nào. Hãy thêm nhân viên để tìm kiếm");
        } else {
            while (true) {
                System.out.println("------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Mời bạn nhập vào Mã Số Nhân Viên muốn tìm kiếm (MSNV XXXXX)");
                id = scanner.nextLine();
                for (int i = 0; i < employeeList.size(); i++) {
                    if (employeeList.get(i).getIdEmployee().equals(id)) {
                        System.out.println("-----------------DANH SÁCH SAU KHI TÌM KIẾM-----------------");
                        System.out.println(employeeList.get(i));
                        check = true;
                        return;
                    }
                }
                if (!check) {
                    System.out.println("ID bạn nhập không tồn tại. Vui lòng kiểm tra lại!");
                }
            }
        }
    }


    public static Employee infoEmployee() throws IOException {
        System.out.println("---------------------------------------------------------");
        System.out.println("Mời bạn nhập vào thông tin cho nhân viên: ");
        Employee employee = InputEmployee.inputEmployee();
        return employee;
    }

}
