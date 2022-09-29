package service;

import bean.Product;

import java.util.List;

public interface IProductServicce {
    List<Product> getAll();

    void save(Product product);

    void delete(int id);

    List<Product> search(String name);
}
