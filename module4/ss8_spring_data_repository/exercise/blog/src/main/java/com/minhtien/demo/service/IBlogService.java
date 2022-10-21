package com.minhtien.demo.service;

import com.minhtien.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(int id);

    Page<Blog> findAllBlog(Pageable pageable);

    Page<Blog> findByAuthor(String author, Pageable pageable);

    Page<Blog> findByEcommerceId (int id, Pageable pageable);
}
