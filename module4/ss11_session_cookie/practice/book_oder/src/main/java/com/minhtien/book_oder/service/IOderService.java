package com.minhtien.book_oder.service;

import com.minhtien.book_oder.model.Oder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IOderService {
    Page<Oder> findAll(Pageable pageable);

    Oder findById(int id);

    void save(Oder oder);

    Oder findByCode (int code);
}
