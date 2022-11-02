package com.minhtien.exercise.repository;

import com.minhtien.exercise.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from blog where author like %:author% and topic like %:topic%", nativeQuery = true)
    Page<Blog> findAuthorAndTopic(@Param("author") String author,
                                  @Param("topic") String topic,
                                  Pageable pageable);

    @Query(value = "select * from blog where catagory_id =:idCatogory and topic like %:topic% and author like %:author%", nativeQuery = true)
    Page<Blog> findAuthorAndTopicAndCatagory(@Param("author") String author,
                                             @Param("topic") String topic,
                                             @Param("idCatogory") Integer idCatogory,
                                             Pageable pageable);

    @Query(value = "select * from blog where catagory_id =:idCatagory", nativeQuery = true)
    Page<Blog> findBlogByCatagory(@Param("idCatagory") Integer idCatagory, Pageable pageable);

    @Query(value = "select * from blog where author like %:author%", nativeQuery = true)
    Page<Blog> findAuthor(@Param("author") String author,
                                  Pageable pageable);
}
