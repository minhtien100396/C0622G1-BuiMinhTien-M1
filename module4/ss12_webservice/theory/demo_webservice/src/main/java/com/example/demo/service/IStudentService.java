package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void save(Student student);
    Student findById(Integer id);
    void delete(Student student);
}
