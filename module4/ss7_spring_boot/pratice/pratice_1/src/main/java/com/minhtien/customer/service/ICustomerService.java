package com.minhtien.customer.service;

import com.minhtien.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);

    List<Customer> findByName(String name);

        Page<Customer> findAll(Pageable pageable);
}
