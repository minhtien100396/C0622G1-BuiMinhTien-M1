package repository;

import model.Customer;
import model.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ICustomerRepository {
    List<Customer> selectAllCustomer();
    Customer selectCustomer(int id);
    List<Customer> selectCustomer(String keyName);
    boolean deleteCustomer(int id) throws SQLException;
    Map<Integer,String> selectAllCustomerType();

}
