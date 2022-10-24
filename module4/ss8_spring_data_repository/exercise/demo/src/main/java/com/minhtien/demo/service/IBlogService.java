package com.minhtien.demo.service;

import com.minhtien.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findByAuthorContaining(String author, Pageable pageable);

    Page<Blog> findByCategoryId(Integer categoryId, Pageable pageable);

    Page<Blog> findByCategoryIdAndAuthor(Integer categoryId, String author, Pageable pageable);

    void save(Blog blog);
}
