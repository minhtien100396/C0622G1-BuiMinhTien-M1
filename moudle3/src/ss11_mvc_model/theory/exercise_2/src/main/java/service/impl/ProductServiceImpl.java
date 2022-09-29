package service.impl;

import bean.Product;
import repository.IProductRepo;
import repository.impl.ProductRepoImpl;
import service.IProductServicce;

import java.util.List;

public class ProductServiceImpl implements IProductServicce {
    IProductRepo iProductRepo = new ProductRepoImpl();
    @Override
    public List<Product> getAll() {
        return iProductRepo.getAll();
    }

    @Override
    public void save(Product product) {
        iProductRepo.save(product);
    }

    @Override
    public void delete(int id) {
        iProductRepo.delete(id);
    }

    @Override
    public List<Product> search(String name) {
        return iProductRepo.search(name);
    }
}
