package com.minhtien.demo.repository;

import com.minhtien.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByAuthorContaining(String author, Pageable pageable);

    @Query(value = "select * from blog join ecommerce on ecommerce.id = blog.e_commerce_id where blog.e_commerce_id =:id", nativeQuery = true)
    Page<Blog> findByECommerceId(@Param("id") int id, Pageable pageble);

    @Query(value = "select * from blog where blog.e_commerce_id =:id and author like %:author%", nativeQuery = true)
    Page<Blog> findAuthorECom(
            @Param("author") String author,
            @Param("id") int id,
            Pageable pageble);
}
