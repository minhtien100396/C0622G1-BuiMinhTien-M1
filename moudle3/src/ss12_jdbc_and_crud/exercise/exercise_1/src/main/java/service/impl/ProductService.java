package service.impl;

import model.Product;
import repo.IProductRepo;
import repo.impl.ProductRepo;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    IProductRepo iProductRepo = new ProductRepo();
    @Override
    public List<Product> getAll() {
        return iProductRepo.getAll();
    }

    @Override
    public void add(Product product) {
        iProductRepo.add(product);
    }

    @Override
    public boolean edit(Product product) {
        return iProductRepo.edit(product);
    }

    @Override
    public boolean delete(int id) {
        return iProductRepo.delete(id);
    }

    @Override
    public List<Product> search(String data) {
        return iProductRepo.search(data);
    }

    @Override
    public void deleteAll() {
        iProductRepo.deleteAll();
    }
}
