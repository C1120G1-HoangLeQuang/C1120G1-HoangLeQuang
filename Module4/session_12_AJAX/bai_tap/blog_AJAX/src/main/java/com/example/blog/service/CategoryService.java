package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();
    Category findById(Integer id);
    void deleteById(Integer id);
    void save(Category category);
}
