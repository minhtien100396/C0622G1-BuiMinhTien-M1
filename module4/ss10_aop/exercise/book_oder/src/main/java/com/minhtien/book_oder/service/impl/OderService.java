package com.minhtien.book_oder.service.impl;

import com.minhtien.book_oder.model.Oder;
import com.minhtien.book_oder.repository.IOderRepository;
import com.minhtien.book_oder.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OderService implements IOderService {
    @Autowired
    private IOderRepository oderRepository;


    @Override
    public Page<Oder> findAll(Pageable pageable) {
        return oderRepository.findAll(pageable);
    }

    @Override
    public Oder findById(int id) {
        return oderRepository.getById(id);
    }

    @Override
    public void save(Oder oder) {
        oderRepository.save(oder);
    }

    @Override
    public Oder findByCode(int code) {
        return oderRepository.findByCode(code);
    }
}
