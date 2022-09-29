package repository;

import bean.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> getAll();

    void save(Product product);

    void delete(int id);

    List<Product> search(String name);
}
