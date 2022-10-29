package com.minhtien.book_oder.service;

import com.minhtien.book_oder.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookServicce {
    Page<Book> findAll(Pageable pageable);

    Book findById(int id);

    void save(Book book);

    Book findByCode(int code);
}
