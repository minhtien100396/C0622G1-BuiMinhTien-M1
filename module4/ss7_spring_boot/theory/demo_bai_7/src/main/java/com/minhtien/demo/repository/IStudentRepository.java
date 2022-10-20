package com.minhtien.demo.repository;

import com.minhtien.demo.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
//    List<Student> findAllByNameContaining(String name);
//    @Query: sẽ giúp viết theo 2 ngôn ngữ HQL và SQL
//    Để nativeQuery = true : viết theo SQL -> native
//    Để trống hoặc = false thì viết theo ngôn ngữ HQL -> JPQL
    @Query(value = "select * from student where name like :name",nativeQuery = true)
    List<Student> searchByName(@Param("name") String name);

//    @Query(value = "select * from student where name like %?1%",nativeQuery = true)
//    List<Student> searchByName(String name);
}
