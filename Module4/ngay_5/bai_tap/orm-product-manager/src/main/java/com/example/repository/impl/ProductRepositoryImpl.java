package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Repository
public class ProductRepositoryImpl implements ProductRepository {

//    @PersistenceContext
//    private EntityManager manager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery("select c from products c", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        if (product.getId() != null) {
            BaseRepository.entityManager.merge(product);
        } else {
            BaseRepository.entityManager.persist(product);
        }
    }

//    @Override
//    public void save(Customer model) {
//        if (model.getId() != null) {
//            em.merge(model);
//        } else {
//            em.persist(model);
//        }
//    }

    @Override
    public Product findById(Integer id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

//    @Override
//    public Customer findById(Long id) {
//        TypedQuery<Customer> query = em.createQuery("select c from Customer c where  c.id=:id", Customer.class);
//        query.setParameter("id", id);
//        try {
//            return query.getSingleResult();
//        } catch (NoResultException e) {
//            return null;
//        }
//    }

//    @Override
//    public void update(Integer id, Product product) {
//        product = findById(id);
//        if (product != null) {
//            BaseRepository.entityManager.merge(product);
//        }
//    }

    @Override
    public void remove(Integer id) {
        Product product = findById(id);
        if (product != null) {
            BaseRepository.entityManager.remove(product);
        }
    }

}
