package repository.impl;

import bean.Product;
import repository.IProductRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepoImpl implements IProductRepo {
    private List<Product> products = new ArrayList<>();

    public ProductRepoImpl() {
        products.add(new Product(1, "Nokia 222", 123, "des1", "nokia"));
        products.add(new Product(2, "Iphone 13", 456, "des2", "apple"));
        products.add(new Product(3, "LG 666", 666, "des3", "LG"));
        products.add(new Product(4, "Samsung E333", 777, "des5", "S amsung"));
        products.add(new Product(5, "Oppo 111", 888, "des6", "Oppo"));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        // id >0 : update, id =0 : add
        if (product.getId() > 0) {
            // update
            //Dùng indexOf thì phải overight lại equals và hashcode
            int index = products.indexOf(product);
            products.set(index, product);
        } else {
            //add
            products.add(product);
        }

    }

    @Override
    public void delete(int id) {
//        for (Product product : products) {
//            if (product.getId() == id) {
//                products.remove(product);
//                break;
//            }
//        }
        products.removeIf(f -> f.getId() == id);
    }

    @Override
    public List<Product> search(String name) {
//        List<Product> result = new ArrayList<>();
//        for (Product product:products) {
//            if (product.getName().contains(name)){
//                result.add(product);
//            }
//        }
//        return result;

        return products.stream().filter(f -> f.getName().contains(name)).collect(Collectors.toList());
    }
}
