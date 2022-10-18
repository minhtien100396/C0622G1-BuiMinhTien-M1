package com.minhtien.service;

import com.minhtien.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    void update(int id, Product product);
    Product findById(int id);
    void delete(int id);
    List<Product> findByName (String name);

}
