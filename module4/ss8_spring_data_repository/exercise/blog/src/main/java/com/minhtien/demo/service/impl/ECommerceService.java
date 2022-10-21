package com.minhtien.demo.service.impl;

import com.minhtien.demo.model.ECommerce;
import com.minhtien.demo.repository.IECommerceRepository;
import com.minhtien.demo.service.IECommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ECommerceService implements IECommerceService {
    @Autowired
    private IECommerceRepository commerceRepository;

    @Override
    public List<ECommerce> findAll() {
        return commerceRepository.findAll();
    }
}
