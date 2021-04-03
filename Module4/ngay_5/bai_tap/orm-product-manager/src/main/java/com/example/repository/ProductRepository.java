package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

//    void update(Integer id, Product product);

    void remove(Integer id);
}
