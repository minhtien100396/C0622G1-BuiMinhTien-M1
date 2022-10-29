package com.minhtien.demo.service.impl;

import com.minhtien.demo.bean.ClassRoom;
import com.minhtien.demo.repository.IClassRepository;
import com.minhtien.demo.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService implements IClassService {
    @Autowired
    private IClassRepository classRepository;

    @Override
    public List<ClassRoom> findAll() {
        return classRepository.findAll();
    }
}
