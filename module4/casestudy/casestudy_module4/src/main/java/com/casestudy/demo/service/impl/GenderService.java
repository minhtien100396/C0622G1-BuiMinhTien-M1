package com.casestudy.demo.service.impl;

import com.casestudy.demo.model.Gender;
import com.casestudy.demo.repository.IGenderRepository;
import com.casestudy.demo.service.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService implements IGenderService {
    @Autowired
    private IGenderRepository genderRepository;

    @Override
    public List<Gender> getList() {
        return genderRepository.findAll();
    }
}
