package com.minhtien.exercise.repository;

import com.minhtien.exercise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String name);
}
