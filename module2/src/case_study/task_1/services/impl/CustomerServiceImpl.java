package case_study.task_1.services.impl;

import case_study.task_1.models.Customer;
import case_study.task_1.services.ICustomerService;
import case_study.task_1.utils.InputCustomer;
import case_study.task_1.utils.read_and_write.ReadFileUtils;
import case_study.task_1.utils.read_and_write.WriteFileUtils;
import case_study.task_1.utils.validate.input_customer.InputAddressCustomerUltils;
import case_study.task_1.utils.validate.input_customer.InputCustomerTypeUltils;
import case_study.task_1.utils.validate.input_person.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    private Scanner scanner = new Scanner(System.in);
    private static List<Customer> customerList = new LinkedList<>();
    private final String CUSTOMER_FILE = "src\\case_study\\task_1\\data\\customer.csv";

    @Override
    public void addCustomer() throws IOException {
        customerList = ReadFileUtils.readFileCustomer(CUSTOMER_FILE);
        Customer customer = this.infoCustomer();
        customerList.add(customer);
        System.out.println("Bạn đã thêm thành công");
        WriteFileUtils.writeFileCustomer(CUSTOMER_FILE, customerList);
    }

    @Override
    public void displayListCustomer() throws IOException {
        customerList = ReadFileUtils.readFileCustomer(CUSTOMER_FILE);
        if (customerList.isEmpty()) {
            System.out.println("Không có bất kì thông tin khách hàng nào trong danh sách");
        } else {
            System.out.println("------------------------------------");
            System.out.println("DANH SÁCH KHÁCH HÀNG");
            for (Customer customer : customerList) {
                System.out.println(customer);
            }
        }
    }

    @Override
    public void editCustomer() throws IOException {
        customerList = ReadFileUtils.readFileCustomer(CUSTOMER_FILE);
        String id;
        int choice;
        boolean check = false;
        displayListCustomer();
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Mời bạn nhập vào Mã Số Khách Hàng muốn chỉnh sửa (MSKH XXXXX)");
        id = scanner.nextLine();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getIdCustomer().equals(id)) {
                System.out.println("Bạn có chắc chắn muốn thay đổi thông tin khách hàng có ID là " + customerList.get(i).getIdCustomer() + " không?");
                System.out.println("1. Có");
                System.out.println("2. Không");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    customerList.get(i).setName(InputNameUltils.inputName());
                    customerList.get(i).setDateOfBirth(InputDateOfBirthUltils.inputDateOfBirth());
                    customerList.get(i).setGender(InputGenderUltils.inputGender());
                    customerList.get(i).setIdCard(InputIdCardUltils.inputIdCard());
                    customerList.get(i).setPhoneNumber(InputPhoneNumberUltils.inputPhoneNumber());
                    customerList.get(i).setEmail(InputEmailUltils.inputEmail());
                    customerList.get(i).setCustomerType(InputCustomerTypeUltils.inputCustomerTypeUltils());
                    customerList.get(i).setAddressCustomer(InputAddressCustomerUltils.inputAddressCustomer());
                    System.out.println("Bạn đã chỉnh sửa thành công");
                    WriteFileUtils.writeFileCustomer(CUSTOMER_FILE, customerList);
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

    public Customer infoCustomer() throws IOException {
        System.out.println("Mời bạn nhập vào thông tin khách hàng: ");
        Customer customer = InputCustomer.inputCustomer();
        return customer;
    }

}
