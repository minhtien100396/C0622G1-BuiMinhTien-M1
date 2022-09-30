package service.impl;

import bean.Customer;
import repository.ICustomerRepo;
import repository.impl.CustomerRepo;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepo iCustomerRepo = new CustomerRepo();
    @Override
    public List<Customer> getAll() {
        return iCustomerRepo.getAll();
    }

    @Override
    public void add(Customer customer) {
        iCustomerRepo.add(customer);
    }

    @Override
    public void edit(Customer customer) {
        iCustomerRepo.edit(customer);
    }

    @Override
    public void delete(int id) {
        iCustomerRepo.delete(id);
    }

    @Override
    public List<Customer> search(String name) {
        return iCustomerRepo.search(name);
    }

    @Override
    public void deleteAll() {
        iCustomerRepo.deleteAll();
    }
}
