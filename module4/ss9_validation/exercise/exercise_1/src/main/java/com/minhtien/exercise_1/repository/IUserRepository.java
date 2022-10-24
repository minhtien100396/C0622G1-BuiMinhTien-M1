package com.minhtien.exercise_1.repository;

import com.minhtien.exercise_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
