package com.minhtien.book_oder.repository;

import com.minhtien.book_oder.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBookRepository extends JpaRepository<Book,Integer> {
    @Query(value = " select * from book join book_order on book.id = book_order.book_id join oder on book_order.order_id = oder.id where code =:code", nativeQuery = true)
    Book findByCode(@Param("code") int code);
}
