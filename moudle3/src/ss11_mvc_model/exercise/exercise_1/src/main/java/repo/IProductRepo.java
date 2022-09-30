package repo;

import model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> getAll();
    void add(Product product);
    void edit(Product product);
    void delete (int id);
    List<Product> search(String name);
    void deleteAll();
}
