package com.minhtien.service;

import com.minhtien.bean.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(Integer id);
    void save(String name, String dateOfBirth);
}
