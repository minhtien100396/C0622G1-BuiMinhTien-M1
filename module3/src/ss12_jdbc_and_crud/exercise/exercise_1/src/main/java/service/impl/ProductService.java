package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    IProductRepository iProductRepository = new ProductRepository();
    @Override
    public List<Product> getAll() {
        return iProductRepository.getAll();
    }

    @Override
    public void add(Product product) {
        iProductRepository.add(product);
    }

    @Override
    public boolean edit(Product product) {
        return iProductRepository.edit(product);
    }

    @Override
    public boolean delete(int id) {
        return iProductRepository.delete(id);
    }

    @Override
    public List<Product> search(String data) {
        return iProductRepository.search(data);
    }

    @Override
    public void deleteAll() {
        iProductRepository.deleteAll();
    }
}
