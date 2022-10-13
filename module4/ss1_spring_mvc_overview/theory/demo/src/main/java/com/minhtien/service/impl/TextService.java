package com.minhtien.service.impl;

import com.minhtien.bean.Student;
import com.minhtien.repository.IStudentRepository;
import com.minhtien.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "textService")
public class TextService implements IStudentService {
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findById(Integer id) {
        return null;
    }

    @Override
    public void save(Student student) {

    }
}
