package service;

import model.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> selectAllCustomer();
    Customer selectCustomer(int idKey);
    List<Customer> selectCustomer(String keyName);
    boolean deleteCustomer(int id) throws SQLException;
    Map<Integer,String> selectAllCustomerType();
    Map<String,String> insertCustomer(Customer customer) throws SQLException;
    Map<String,String> updateCustomer1(Customer customer) throws SQLException;
    boolean updateCustomer(Customer customer) throws SQLException;

}