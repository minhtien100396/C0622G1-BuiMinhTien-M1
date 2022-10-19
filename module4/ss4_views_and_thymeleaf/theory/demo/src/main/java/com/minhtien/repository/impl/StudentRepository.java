package com.minhtien.repository.impl;

import com.minhtien.bean.Student;
import com.minhtien.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {


    @Override
    public List<Student> findAll() {
        //HQL -> Hybernate Query Language.
        List<Student> studentList = BaseRepository.entityManager.createQuery
                                    ("select s from student s",Student.class).getResultList();
        return studentList;
    }

    @Override
    public Student findById(Integer id) {
        // Chỉ hỗ trợ tìm kiếm theo Id khóa chính
        Student student = BaseRepository.entityManager.find(Student.class,id);
        return student;
    }

    @Override
    public void save(Student student) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        //merge : cập nhật
        BaseRepository.entityManager.persist(student);
        entityTransaction.commit();
    }
}
