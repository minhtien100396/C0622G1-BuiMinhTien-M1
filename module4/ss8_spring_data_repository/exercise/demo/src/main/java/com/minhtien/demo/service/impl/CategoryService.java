package com.minhtien.demo.service.impl;

import com.minhtien.demo.model.Category;
import com.minhtien.demo.repository.ICategoryRepository;
import com.minhtien.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService  {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
