package service;

import bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    void add(Product product);
    void edit(Product product);
    void delete (int id);
    List<Product> search(String name);
    void deleteAll();

}
