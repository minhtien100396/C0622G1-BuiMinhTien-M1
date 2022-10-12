package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    void add(Product product);
    boolean edit(Product product);
    boolean delete (int id);
    List<Product> search(String data);
    void deleteAll();

}
