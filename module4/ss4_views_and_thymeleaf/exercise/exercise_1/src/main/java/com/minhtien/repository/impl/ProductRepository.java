package com.minhtien.repository.impl;

import com.minhtien.model.Product;
import com.minhtien.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1, "Iphone11", 10000.0, "Điện Thoại", "Apple"));
        productMap.put(2, new Product(2, "SamsungE33", 20000.0, "Điện Thoại", "Samsung"));
        productMap.put(3, new Product(3, "NokiaG8", 5000.0, "Điện Thoại", "Nokia"));
        productMap.put(4, new Product(4, "DellXPS", 40000.0, "Điện Thoại", "Dell"));
        productMap.put(5, new Product(5, "Vaio9", 50000.0, "Điện Thoại", "Vaio"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void delete(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productListByName = new ArrayList<>();
        for (Product product : productMap.values()) {
            if (product.getName().contains(name)){
                productListByName.add(product);
            }
        }
        return productListByName;
    }


}
