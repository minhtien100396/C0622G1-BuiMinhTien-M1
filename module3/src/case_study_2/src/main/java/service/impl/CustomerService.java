package service.impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;
import validation.Validation;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> selectAllCustomer() {
        return customerRepository.selectAllCustomer();
    }

    @Override
    public Customer selectCustomer(int idKey) {
        return customerRepository.selectCustomer(idKey);
    }

    @Override
    public List<Customer> selectCustomer(String keyName) {
        return customerRepository.selectCustomer(keyName);
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public Map<Integer, String> selectAllCustomerType() {
        return customerRepository.selectAllCustomerType();
    }

    @Override
    public Map<String, String> insertCustomer(Customer customer) throws SQLException {
        Map<String, String> errorMap = new HashMap<>();
        if (customer.getEmail().equals("")) {
            errorMap.put("email", "Email không được để trống!");
        } else if (!Validation.checkEmail(customer.getEmail())) {
            errorMap.put("email", "Email không đúng định dạng");
        }
        if (customer.getName().equals("")) {
            errorMap.put("name", "Name không được để trống!");
        } else if (!Validation.checkName(customer.getName())) {
            errorMap.put("name", "Name không đúng định dạng");
        }
        if (customer.getAddress().equals("")) {
            errorMap.put("address", "Address không được để trống!");
        } else if (!Validation.checkAddress(customer.getAddress())) {
            errorMap.put("address", "Address không đúng định dạng");
        }
        if (customer.getIdCard().equals("")) {
            errorMap.put("idCard", "IdCard không được để trống!");
        }
        if (customer.getPhoneNumber().equals("")) {
            errorMap.put("phoneNumber", "Phone không được để trống!");
        } else if (!Validation.checkPhone(customer.getPhoneNumber())) {
            errorMap.put("phoneNumber", "Phone không đúng định dạng (XX)-(0XXXXXXXXX)");
        }
        if (customer.getCustomerTypeId() == 100) {
            errorMap.put("customerTypeId", "Customer Type không được để trống!");
        }
        if (customer.getGender() == 100) {
            errorMap.put("gender", "Gender không được để trống!");
        }
        if (customer.getDateOfBirth().equals("")){
            errorMap.put("dateOfBirth", "Date Of Birth không được để trống!");
        } else {
            int age = LocalDate.now().getYear() - LocalDate.parse(customer.getDateOfBirth()).getYear();
            if (age < 18 || age > 100) {
                errorMap.put("dateOfBirth", "Date Of Birth không hợp lệ (age>18 && age<100)");
            }
        }

        if (errorMap.size() == 0) {
            boolean check = customerRepository.insertCustomer(customer);
        }
        return errorMap;
    }

    @Override
    public Map<String, String> updateCustomer1(Customer customer) throws SQLException {

        Map<String, String> errorMap = new HashMap<>();
        if (customer.getEmail().equals("")) {
            errorMap.put("email", "Email không được để trống!");
        } else if (!Validation.checkEmail(customer.getEmail())) {
            errorMap.put("email", "Email không đúng định dạng");
        }
        if (customer.getName().equals("")) {
            errorMap.put("name", "Name không được để trống!");
        } else if (!Validation.checkName(customer.getName())) {
            errorMap.put("name", "Name không đúng định dạng");
        }
        if (customer.getAddress().equals("")) {
            errorMap.put("address", "Address không được để trống!");
        } else if (!Validation.checkAddress(customer.getAddress())) {
            errorMap.put("address", "Address không đúng định dạng");
        }
        if (customer.getIdCard().equals("")) {
            errorMap.put("idCard", "IdCard không được để trống!");
        }
        if (customer.getPhoneNumber().equals("")) {
            errorMap.put("phoneNumber", "Phone không được để trống!");
        } else if (!Validation.checkPhone(customer.getPhoneNumber())) {
            errorMap.put("phoneNumber", "Phone không đúng định dạng (XX)-(0XXXXXXXXX)");
        }
        if (customer.getCustomerTypeId() == 100) {
            errorMap.put("customerTypeId", "Customer Type không được để trống!");
        }
        if (customer.getGender() == 100) {
            errorMap.put("gender", "Gender không được để trống!");
        }
        int age = LocalDate.now().getYear() - LocalDate.parse(customer.getDateOfBirth()).getYear();
        if (age < 18 || age > 100) {
            errorMap.put("dateOfBirth", "dateOfBirth không hợp lệ (age>18 && age<100)");
        }
        if (errorMap.size() == 0) {
            boolean check = customerRepository.updateCustomer(customer);
        }
        return errorMap;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return customerRepository.updateCustomer(customer);
    }
}
