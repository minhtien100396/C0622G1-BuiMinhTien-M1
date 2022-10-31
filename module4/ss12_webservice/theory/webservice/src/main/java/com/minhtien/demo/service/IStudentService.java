package com.minhtien.demo.service;

import com.minhtien.demo.bean.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    Student findById(Integer id);

    void save(Student student);

    List<Student> searchByName(String searchName);


    // Pageable -> Giúp sort, lấy được số phần tử của một trang cũng như lấy số trang
    Page<Student> findAll(Pageable pageable);
}
