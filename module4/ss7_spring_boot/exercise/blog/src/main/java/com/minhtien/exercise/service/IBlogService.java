package com.minhtien.exercise.service;

import com.minhtien.exercise.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

    List<Blog> findByName(String name);

    Page<Blog> findAll(Pageable pageable);


}
