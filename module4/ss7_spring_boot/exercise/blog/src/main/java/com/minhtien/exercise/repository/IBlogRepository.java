package com.minhtien.exercise.repository;

import com.minhtien.exercise.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select * from blog where author like :name",nativeQuery = true)
    List<Blog> findByName(@Param("name") String name);
}
