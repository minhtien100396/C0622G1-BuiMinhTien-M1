package com.casestudy.demo.service.impl;

import com.casestudy.demo.model.CustomerType;
import com.casestudy.demo.repository.ICustomerTypeRepository;
import com.casestudy.demo.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> getList() {
        return customerTypeRepository.findAll();
    }
}
