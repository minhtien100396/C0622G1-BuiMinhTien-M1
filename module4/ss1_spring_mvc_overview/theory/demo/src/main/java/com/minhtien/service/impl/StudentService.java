package com.minhtien.service.impl;

import com.minhtien.bean.Student;
import com.minhtien.repository.IStudentRepository;
import com.minhtien.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "studentService")
public class StudentService implements IStudentService {
//  DI = Dependency Inversion
//  DI = Interface
//    DI = Construstor
//    DI = setter
    @Autowired
    private IStudentRepository studentRepository;
    // tương đương với câu lệnh private IStudentRepository studentRepository = new StudentRepository();
// Nếu tạo đối tượng bằng từ khóa new thì mỗi lần tạo sẽ tạo ra các đối tượng khác nhau -> Không thỏa man Design Pattren Sigleton
//    Liên quan đến sự phụ thuộc lẫn nhau giữa các tầng Controller Service và Repo -> sự phụ thuộc này sẽ đưa cho thằng Spring quản lý bằng cái DI
    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(String name, String dateOfBirth) {
        studentRepository.save(name,dateOfBirth);
    }
}
