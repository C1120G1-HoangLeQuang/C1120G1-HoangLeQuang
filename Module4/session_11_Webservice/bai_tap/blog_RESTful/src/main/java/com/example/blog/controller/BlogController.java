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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

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

    //-------------------Create a Blog--------------------------------------------------------

    @PostMapping("/blog/create")
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog, UriComponentsBuilder builder) {
        this.blogService.save(blog);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(builder.path("/blog/create/{id}").buildAndExpand(blog.getId()).toUri());
        return new ResponseEntity<Blog>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/blog/update/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable("id") Integer id, @RequestBody Blog blog) {
        System.out.println("Updating blog: " + id);
        Blog currentBlog = this.blogService.findById(id);
        if (currentBlog == null) {
            System.out.println("Current Blog" + id + "not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        currentBlog.setCategory(blog.getCategory());
        currentBlog.setId(blog.getId());
        currentBlog.setContent(blog.getContent());
        currentBlog.setDateRelease(blog.getDateRelease());
        currentBlog.setNameBlog(blog.getNameBlog());
        currentBlog.setWriter(blog.getWriter());
        this.blogService.save(currentBlog);
        return new ResponseEntity<Blog>(currentBlog, HttpStatus.OK);
    }

    //------------------- Delete a Blog --------------------------------------------------------

    @DeleteMapping("/blog/delete/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") Integer id) {
        System.out.println("Delete blog with id: " + id);
        Blog blog = this.blogService.findById(id);
        if (blog == null) {
            System.out.println("Unable to delete with Blog id " + id + "not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        this.blogService.deleteById(id);
        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
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

    //-------------------Create a Category--------------------------------------------------------
    @PostMapping("/category/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category, UriComponentsBuilder builder) {
        this.categoryService.save(category);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/category/create/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<Category>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Category --------------------------------------------------------
    @PutMapping("/category/update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Integer id, @RequestBody Category category) {
        System.out.println("Update category with id: " + id);
        Category currentCategory = this.categoryService.findById(id);
        if (currentCategory == null) {
            System.out.println("Category to update is not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        currentCategory.setId(category.getId());
        currentCategory.setName(category.getName());
        currentCategory.setBlogs(category.getBlogs());
        this.categoryService.save(currentCategory);
        return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
    }

    //------------------- Delete a Category --------------------------------------------------------
    @DeleteMapping("/category/delete/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") Integer id) {
        System.out.println("Delete catagory with id: " + id);
        Category category = this.categoryService.findById(id);
        if (category == null) {
            System.out.println("Category to delete is not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        this.categoryService.deleteById(id);
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }
}
