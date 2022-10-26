package repository;

import model.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ICustomerRepository {
    List<Customer> selectAllCustomer();
    Customer selectCustomer(int idKey);
    List<Customer> selectCustomer(String keyName);
    boolean deleteCustomer(int id) throws SQLException;
    Map<Integer,String> selectAllCustomerType();
    boolean insertCustomer(Customer customer) throws SQLException;
    boolean updateCustomer(Customer customer) throws SQLException;
}