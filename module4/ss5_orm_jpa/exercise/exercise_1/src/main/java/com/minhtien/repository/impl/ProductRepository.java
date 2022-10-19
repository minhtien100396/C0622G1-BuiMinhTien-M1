package com.minhtien.repository.impl;

import com.minhtien.model.Product;
import com.minhtien.repository.IProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product as p", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }


    @Override
    public void update(int id, Product product) {
        entityManager.merge(product);
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }


    @Override
    public void remove(int id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    @Override
    public List<Product> findByName(String name) {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product as p where p.name like :name", Product.class).setParameter("name","%"+name+"%");
        return query.getResultList();
    }


}
