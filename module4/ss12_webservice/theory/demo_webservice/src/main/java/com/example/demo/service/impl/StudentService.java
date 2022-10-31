package com.example.demo.service.impl;

import com.example.demo.model.Student;
import com.example.demo.repository.IStudentRepository;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }
}
