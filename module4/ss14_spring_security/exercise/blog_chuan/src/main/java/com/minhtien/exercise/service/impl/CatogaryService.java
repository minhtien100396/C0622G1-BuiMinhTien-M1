package com.minhtien.exercise.service.impl;

import com.minhtien.exercise.model.Catagory;
import com.minhtien.exercise.repository.ICatagoryRepository;
import com.minhtien.exercise.service.ICatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatogaryService implements ICatagoryService {
    @Autowired
    private ICatagoryRepository catagoryRepository;

    @Override
    public List<Catagory> findAll() {
        return catagoryRepository.findAll();
    }
}
