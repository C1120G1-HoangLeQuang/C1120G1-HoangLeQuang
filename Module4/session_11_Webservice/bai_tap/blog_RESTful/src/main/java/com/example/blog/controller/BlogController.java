package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {

    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    //-------------------Retrieve All Blogs--------------------------------------------------------

    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> getListBlog() {
        List<Blog> blogs = this.blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }

    //-------------------Retrieve Single Blog--------------------------------------------------------

    @GetMapping(value = "/blog/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> getBlog(@PathVariable("id") Integer id) {
        Blog blog = this.blogService.findById(id);
        if (blog == null) {
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }

    //-------------------Retrieve All Category--------------------------------------------------------

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getListCategory() {
        List<Category> categories = this.categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }

    //-------------------Retrieve Single Blog--------------------------------------------------------

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") Integer id) {
        Category category = this.categoryService.findById(id);
        if (category == null) {
            System.out.println("Category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }
}
