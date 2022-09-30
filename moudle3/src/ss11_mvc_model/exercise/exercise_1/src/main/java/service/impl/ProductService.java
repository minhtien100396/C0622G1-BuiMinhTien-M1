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
    public void edit(Product product) {
        iProductRepo.edit(product);
    }

    @Override
    public void delete(int id) {
        iProductRepo.delete(id);
    }

    @Override
    public List<Product> search(String name) {
        return iProductRepo.search(name);
    }

    @Override
    public void deleteAll() {
        iProductRepo.deleteAll();
    }
}
