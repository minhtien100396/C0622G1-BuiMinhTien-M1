package com.casestudy.demo.service.impl;

import com.casestudy.demo.model.Customer;
import com.casestudy.demo.repository.ICustomerRepository;
import com.casestudy.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;


    @Override
    public Page<Customer> findByNameAndEmailAndCustomerType(String name, String email, String customerTypeId, String status, Pageable pageable) {
        return customerRepository.findByNameAndEmailAndCustomerTypeId(name, email, customerTypeId, status, pageable);
    }

    @Override
    public Page<Customer> getPage(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findByNameAndEmail(String name, String email, String status, Pageable pageable) {
        return customerRepository.findPageNameAndEmail(name, email, status, pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> findByStatus(String status, Pageable pageable) {
        return customerRepository.findPageStatus(status, pageable);
    }
}
