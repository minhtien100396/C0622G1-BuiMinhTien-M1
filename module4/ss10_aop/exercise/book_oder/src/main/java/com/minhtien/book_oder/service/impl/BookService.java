package com.minhtien.book_oder.service.impl;

import com.minhtien.book_oder.model.Book;
import com.minhtien.book_oder.repository.IBookRepository;
import com.minhtien.book_oder.service.IBookServicce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookServicce {
    @Autowired
    private IBookRepository bookRepository;


    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findByCode(int code) {
        return bookRepository.findByCode(code);
    }


}
