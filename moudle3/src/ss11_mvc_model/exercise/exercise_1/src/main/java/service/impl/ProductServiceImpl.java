package service.impl;

import bean.Product;
import repository.IProductRepo;
import repository.impl.ProductRepoImpl;
import service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    IProductRepo iProductRepo = new ProductRepoImpl();
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
