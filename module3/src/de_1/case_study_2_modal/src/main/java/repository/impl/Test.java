package repository.impl;

import repository.IProductRepository;

public class Test {
    public static void main(String[] args) {
        IProductRepository repo = new ProductRepository();
        System.out.println("Size : "+ repo.selectAllCategory().size());
    }
}
