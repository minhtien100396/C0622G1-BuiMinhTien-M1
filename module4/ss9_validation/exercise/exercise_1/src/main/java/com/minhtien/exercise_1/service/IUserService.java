package com.minhtien.exercise_1.service;

import com.minhtien.exercise_1.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User> findAll(Pageable pageable);
    void save(User user);
}
