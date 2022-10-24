package com.minhtien.demo.service.impl;

import com.minhtien.demo.model.Blog;
import com.minhtien.demo.repository.IBlogRepository;
import com.minhtien.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> findAllBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findByAuthor(String author, Pageable pageable) {
        return blogRepository.findByAuthorContaining(author,pageable);
    }

    @Override
    public Page<Blog> findByEcommerceId(int id, Pageable pageable) {
        return blogRepository.findByECommerceId(id,pageable);
    }

    @Override
    public Page<Blog> findByAuthorAndEcommerceId(String author, int id, Pageable pageable) {
        return blogRepository.findAuthorECom(author,id,pageable);
    }
}
