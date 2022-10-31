package com.minhtien.exercise.service;

import com.minhtien.exercise.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

    Page<Blog> searchByNameAndTopic(String name, String topic, Pageable pageable);

    Page<Blog> searchByNameAndTopicAndCatagory(String name, String topic, Integer idCatagory, Pageable pageable);
    Page<Blog> findBlogByCatagory(Integer idCatagory,Pageable pageable);
}
