package com.minhtien.demo.repository;

import com.minhtien.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByAuthorContaining(String author, Pageable pageable);

    @Query(value = "select * from blog join category on blog.category_id = category.id  where blog.category_id =:categoryId", nativeQuery = true)
    Page<Blog> findByCategoryId(@Param("categoryId") Integer categoryId, Pageable pageable);

    @Query(value = "select * from blog where blog.category_id =:categoryId and author like %:author% ", nativeQuery = true)
    Page<Blog> findByCategoryIdAndAuthor(@Param("categoryId") Integer categoryId,
                                         @Param("author") String author,
                                         Pageable pageable);
}
