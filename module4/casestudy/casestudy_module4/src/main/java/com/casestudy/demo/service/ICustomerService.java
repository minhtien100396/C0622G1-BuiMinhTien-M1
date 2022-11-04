package com.casestudy.demo.service;

import com.casestudy.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findByNameAndEmailAndCustomerType(String name, String email, String customerTypeId, String status, Pageable pageable);

    Page<Customer> getPage(Pageable pageable);

    Page<Customer> findByNameAndEmail(String name, String email, String status, Pageable pageable);

    Customer findById(Integer id);

    void save(Customer customer);

    Page<Customer> findByStatus(String status, Pageable pageable);
}
