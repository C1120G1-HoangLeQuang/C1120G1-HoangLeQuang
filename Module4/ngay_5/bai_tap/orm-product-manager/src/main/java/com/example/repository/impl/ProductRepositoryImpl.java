package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityTransaction;

//import javax.persistence.*;
import javax.persistence.TypedQuery;
import java.util.List;


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
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }


    @Override
    public Product findById(Integer id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }


    @Override
    public void remove(Integer id) {
        Product product = findById(id);
        if (product != null) {
            BaseRepository.entityManager.remove(product);
        }
    }

}
