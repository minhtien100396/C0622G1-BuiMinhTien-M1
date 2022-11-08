package com.casestudy.demo.service.impl;

import com.casestudy.demo.model.Employee;
import com.casestudy.demo.repository.IEmployeeRepository;
import com.casestudy.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> getList() {
        return employeeRepository.findAll();
    }
}
