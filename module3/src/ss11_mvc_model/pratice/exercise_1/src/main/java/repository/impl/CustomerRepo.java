package repository.impl;

import bean.Customer;
import repository.ICustomerRepo;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepo implements ICustomerRepo {
    private static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1, "Nguyễn Duy Quang", "quangnguyen@gmail.com", "Huế"));
        customers.add(new Customer(2, "Phạm Thế Sơn", "sonpham@gmail.com", "Đà Nẵng"));
        customers.add(new Customer(3, "Lê Bá Hoàng Giang", "giangle@gmail.com", "Quảng Bình"));
        customers.add(new Customer(4, "Nguyễn Văn Huy", "huynguyen@gmail.com", "Quảng Trị"));
        customers.add(new Customer(5, "Đỗ Quốc Viết", "vietdo@gmail.com", "Quảng Nam"));
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }

    @Override
    public void add(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void edit(Customer customer) {
        int index = customers.indexOf(customer);
        customers.set(index, customer);
    }

    @Override
    public void delete(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customers.remove(customer);
                break;
            }
        }
    }

    @Override
    public List<Customer> search(String name) {
        List<Customer> searchResult = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getName().contains(name)){
                searchResult.add(customer);
            }
        }
        return searchResult;
    }

    @Override
    public void deleteAll() {
        customers.clear();
    }
}
