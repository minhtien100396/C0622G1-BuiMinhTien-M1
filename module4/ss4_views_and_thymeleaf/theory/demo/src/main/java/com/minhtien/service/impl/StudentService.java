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
        //orElse sẽ trả về null nếu không tìm thây đối tượng student  có id là id
        return this.studentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Student student) {
        //Sử dụng cho cả update và thêm mới
        // Khi có id trong Student -> cập nhật
        // id = null or không có trong DB -> thêm mới
        this.studentRepository.save(student);
//        studentRepository.deleteById(student.getId());
    }

    @Override
    public List<Student> searchByName(String searchName) {
//        return studentRepository.searchByName("%"+searchName+"%");
        return studentRepository.searchByName("%"+searchName+"%");
    }
}
