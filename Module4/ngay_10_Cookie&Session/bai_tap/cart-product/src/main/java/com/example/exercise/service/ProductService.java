package com.example.exercise.service;

import com.example.exercise.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    void save(Product product);
    Product findById(Integer id);
    void deleteById(Integer id);
}
