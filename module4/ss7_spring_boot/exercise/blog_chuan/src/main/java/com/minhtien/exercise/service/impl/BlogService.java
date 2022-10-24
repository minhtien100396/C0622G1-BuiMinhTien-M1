package com.minhtien.exercise.service.impl;

import com.minhtien.exercise.model.Blog;
import com.minhtien.exercise.repository.IBlogRepository;
import com.minhtien.exercise.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> searchByNameAndTopic(String name, String topic, Pageable pageable) {
        return blogRepository.findAuthorAndTopic(name, topic, pageable);
    }

    @Override
    public Page<Blog> searchByNameAndTopicAndCatagory(String name, String topic, Integer idCatagory, Pageable pageable) {
        return blogRepository.findAuthorAndTopicAndCatagory(name, topic, idCatagory, pageable);
    }

}
