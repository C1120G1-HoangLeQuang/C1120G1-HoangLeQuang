package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface ProductService {

   List<Product> findAll();

   void save(Product product);

   Product findById(Integer id);

//   void update(Integer id, Product product);

   void remove(Integer id);
}
