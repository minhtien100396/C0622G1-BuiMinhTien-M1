package repository;

import bean.Customer;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> getAll();
    void add(Customer customer);
    void edit(Customer customer);
    void delete (int id);
    List<Customer> search(String name);
    void deleteAll();
}
