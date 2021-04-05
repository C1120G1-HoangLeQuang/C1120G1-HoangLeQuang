package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public ModelAndView getListBlog() {
       return new ModelAndView("list", "blogs", this.blogService.findAll());
    }

    @GetMapping("blog/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("create", "blogs", new Blog());
    }

    @PostMapping("/blog/save")
    public String creatNewBlog(Blog blog) {
        this.blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/blog/edit")
    public ModelAndView showEditForm(@RequestParam Integer id) {
        return new ModelAndView("edit", "blogs", this.blogService.findById(id));
    }

    @PostMapping("/blog/update")
    public String editBlog(Blog blog) {
        this.blogService.save(blog);
        return "redirect:/";
    }

    @PostMapping("/blog/delete")
    public String deleteBlog(@RequestParam Integer id) {
        this.blogService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/blog/view")
    public ModelAndView viewBlog(@RequestParam Integer id) {
        return new ModelAndView("view", "blogs", this.blogService.findById(id));
    }
}
