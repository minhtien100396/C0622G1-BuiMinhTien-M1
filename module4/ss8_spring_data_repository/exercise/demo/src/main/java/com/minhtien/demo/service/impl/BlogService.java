package com.minhtien.demo.service.impl;

import com.minhtien.demo.model.Blog;
import com.minhtien.demo.repository.IBlogRepository;
import com.minhtien.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository repository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Blog> findByAuthorContaining(String author, Pageable pageable) {
        return repository.findByAuthorContaining(author,pageable);
    }

    @Override
    public Page<Blog> findByCategoryId(Integer categoryId, Pageable pageable) {
        return repository.findByCategoryId(categoryId,pageable);
    }

    @Override
    public Page<Blog> findByCategoryIdAndAuthor(Integer categoryId, String author, Pageable pageable) {
        return repository.findByCategoryIdAndAuthor(categoryId,author,pageable);
    }

    @Override
    public void save(Blog blog) {
        repository.save(blog);
    }
}
