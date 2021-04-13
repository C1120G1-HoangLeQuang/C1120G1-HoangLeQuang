package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    BlogService blogService;

    @GetMapping("/category")
    public ModelAndView getListCategory() {
        return new ModelAndView("category/listCategory", "categoryList", this.categoryService.findAll());
    }

    @GetMapping("category/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("category/createCategory", "categoryList", new Category());
    }

    @PostMapping("/category/save")
    public String creatNewCategory(Category category) {
        this.categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/category/edit")
    public ModelAndView showEditForm(@RequestParam Integer id) {
        return new ModelAndView("category/editCategory", "categoryList", this.categoryService.findById(id));
    }

    @PostMapping("/category/update")
    public String editCategory(Category category) {
        this.categoryService.save(category);
        return "redirect:/category";
    }

    @PostMapping("/category/delete")
    public String deleteCategory(@RequestParam Integer id) {
        this.categoryService.deleteById(id);
        return "redirect:/category";
    }

//    @GetMapping("/category/view-province/")
//    public ModelAndView viewCategory(@RequestParam("id") Integer id, Pageable pageable){
//        Category category = categoryService.findById(id);
//        Page<Blog> blogs = blogService.findAllByCategoryContaining(category, pageable);
//        ModelAndView modelAndView = new ModelAndView("/category/viewCategory");
//        modelAndView.addObject("categoryList", category);
//        modelAndView.addObject("blogs", blogs);
//        return modelAndView;
//    }
}
