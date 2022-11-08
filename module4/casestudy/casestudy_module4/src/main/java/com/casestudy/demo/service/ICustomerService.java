package com.casestudy.demo.service;

import com.casestudy.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findByNameAndEmailAndCustomerType(String name, String email, String customerType, Pageable pageable);

    Customer findById(Integer id);

    void save(Customer customer);

    List<Customer> getList();
}
