package com.minhtien.repository;

import com.minhtien.bean.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    Student findById(Integer id);
    void save(String name, String dateOfBirth);
}
