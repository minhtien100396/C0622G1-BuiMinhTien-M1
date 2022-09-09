package case_study.task_1.utils;

import case_study.task_1.models.Customer;
import case_study.task_1.utils.validate.input_customer.InputAddressCustomerUltils;
import case_study.task_1.utils.validate.input_customer.InputCustomerTypeUltils;
import case_study.task_1.utils.validate.input_customer.InputIdCustomerUltils;

import java.io.IOException;

public class InputCustomer extends InputPerson {
    private static String idCustomer;
    private static String customerType;
    private static String addressCustomer;

    public static Customer inputCustomer() throws IOException {
        InputPerson.inputPerson();
        idCustomer = InputIdCustomerUltils.inputIdCustomer();
        customerType = InputCustomerTypeUltils.inputCustomerTypeUltils();
        addressCustomer = InputAddressCustomerUltils.inputAddressCustomer();
        Customer customer = new Customer(name, dateOfBirth, gender, idCard, phoneNumber, email,
                idCustomer, customerType, addressCustomer);
        return customer;
    }
}
