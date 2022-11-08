package com.codegym.service;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    Page<Customer> search(String nameSearch, String emailSearch, String customerTypeSearch, Pageable pageable);

    Optional<Customer> findById(int id);

    void removeCustomer(Customer customer);

    List<Customer> findAll();
}
