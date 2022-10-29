package com.minhtien.demo.service;

import com.minhtien.demo.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findALl();

    Optional<Product> findById(Integer id);

    void save(Product product);
}
