package com.casestudy.demo.service.impl;

import com.casestudy.demo.model.RentType;
import com.casestudy.demo.repository.IRentTypeRepository;
import com.casestudy.demo.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> getList() {
        return rentTypeRepository.findAll();
    }
}
