package repository.impl;

import bean.Product;
import repository.IProductRepo;

import java.util.ArrayList;
import java.util.List;

public class ProductRepoImpl implements IProductRepo {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Nokia 222", 123, "des1", "nokia"));
        products.add(new Product(2, "Iphone 13", 456, "des2", "apple"));
        products.add(new Product(3, "LG 666", 666, "des3", "LG"));
        products.add(new Product(4, "Samsung E333", 777, "des5", "Samsung"));
        products.add(new Product(5, "Oppo 111", 888, "des6", "Oppo"));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void edit(Product product) {
        int index = products.indexOf(product);
        products.set(index, product);
    }

    @Override
    public void delete(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                break;
            }
        }
    }

    @Override
    public List<Product> search(String name) {
        List<Product> searchResult = new ArrayList<>();
        for (Product product:products) {
            if (product.getName().contains(name)){
                searchResult.add(product);
            }
        }
        return searchResult;
    }

    @Override
    public void deleteAll() {
        products.clear();
    }
}
