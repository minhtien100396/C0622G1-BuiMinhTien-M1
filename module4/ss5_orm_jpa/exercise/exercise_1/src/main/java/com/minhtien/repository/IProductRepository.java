package com.minhtien.repository;

import com.minhtien.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    void update(int id, Product product);

    Product findById(int id);

    void remove(int id);

    List<Product> findByName(String name);
}
