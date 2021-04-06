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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/blog")
    public ModelAndView getListBlog(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                    @RequestParam(name = "size", required = false, defaultValue = "2") Integer size,
                                    @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                                    @RequestParam("nameBlog") Optional<String> nameBlog) {
        Page<Blog> blogs;
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("dateRelease").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("dateRelease").descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);

        if (nameBlog.isPresent()) {
            blogs = this.blogService.findAllByNameBlogContaining(nameBlog.get(), pageable);
        } else {
            blogs = this.blogService.findAll(pageable);
        }
        return new ModelAndView("blog/list", "blogs", blogs);
    }

    @GetMapping("/blog/view-category")
    public ModelAndView viewCategory(Pageable pageable, Model model){
        List<Category> category = categoryService.findAll();
        Page<Blog> blogs = blogService.findAllByCategoryContaining(category, pageable);
        ModelAndView modelAndView = new ModelAndView("/blog/viewCategory");
        modelAndView.addObject("categoryList", category);
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }



    @GetMapping("blog/create")
    public ModelAndView showCreateForm(Model model) {
        model.addAttribute("categoryList", this.categoryService.findAll());
        return new ModelAndView("blog/create", "blogs", new Blog());
    }

    @PostMapping("/blog/save")
    public String creatNewBlog(Blog blog) {
        this.blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/blog/edit")
    public ModelAndView showEditForm(@RequestParam Integer id, Model model) {
        model.addAttribute("categoryList", this.categoryService.findAll());
        return new ModelAndView("blog/edit", "blogs", this.blogService.findById(id));
    }

    @PostMapping("/blog/update")
    public String editBlog(Blog blog) {
        this.blogService.save(blog);
        return "redirect:/blog";
    }

    @PostMapping("/blog/delete")
    public String deleteBlog(@RequestParam Integer id) {
        this.blogService.deleteById(id);
        return "redirect:/blog";
    }

    @GetMapping("/blog/view")
    public ModelAndView viewBlog(@RequestParam Integer id) {
        return new ModelAndView("blog/view", "blogs", this.blogService.findById(id));
    }

}
