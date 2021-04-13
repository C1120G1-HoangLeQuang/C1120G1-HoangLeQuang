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

//    @GetMapping("/blog")
//    public ModelAndView getListBlog(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
//                                    @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
//                                    @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
//                                    @RequestParam("nameBlog") Optional<String> nameBlog) {
//        Page<Blog> blogPage;
//        Sort sortable = null;
//        Pageable pageable = null;
//        if (sort.equals("ASC")) {
//            sortable = Sort.by("dateRelease").ascending();
//        }
//        if (sort.equals("DESC")) {
//            sortable = Sort.by("dateRelease").descending();
//        }
//        pageable = PageRequest.of(page, size, sortable);
//        ModelAndView modelAndView = new ModelAndView("blog/list");
//
//        modelAndView.addObject("reverseSort", sort.equals("ASC") ? "DESC" : "ASC");
//        if (nameBlog.isPresent()) {
//            blogPage = this.blogService.findAllByNameBlogContaining(nameBlog.get(), pageable);
//        } else {
//            blogPage = this.blogService.findAll(pageable);
//        }
//        modelAndView.addObject("blogs", blogPage);
//        return modelAndView;
//    }

    @GetMapping("/blog")
    public ModelAndView getListBlog(Pageable pageable) {
        Pageable pageableSortByDateRelease = PageRequest.of(pageable.getPageNumber(), 3, Sort.by("dateRelease").descending());
        Page<Blog> blogList = this.blogService.findAll(pageableSortByDateRelease);
        ModelAndView modelAndView = new ModelAndView("blog/list");
        modelAndView.addObject("reverseSort", "ASC");
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

    @GetMapping("/blog/search")
    public String searchByNameBlog(Model model, @RequestParam("nameBlog") Optional<String> nameBlog, @PageableDefault(value = 3) Pageable pageable) {
        Page<Blog> blogList;
        Pageable pageableSortByDateRelease = PageRequest.of(pageable.getPageNumber(), 3, Sort.by("dateRelease").descending());
        if (nameBlog.isPresent()) {
            blogList = this.blogService.findAllByNameBlogContaining(nameBlog.get(), pageableSortByDateRelease);
            model.addAttribute("nameBlog", nameBlog.get());
        } else {
            blogList = this.blogService.findAll(pageableSortByDateRelease);
        }
        model.addAttribute("blogList", blogList);
        return "blog/list";
    }

    @GetMapping("/blog/sort")
    public ModelAndView sortByDayRelease(@RequestParam String sort, Pageable pageable) {
        Page<Blog> blogList;
        Pageable pageableSortByDateRelease = null;
        if (sort.equals("ASC")) {
            pageableSortByDateRelease = PageRequest.of(pageable.getPageNumber(), 3, Sort.by("dateRelease").ascending());
        }
        if (sort.equals("DESC")) {
            pageableSortByDateRelease = PageRequest.of(pageable.getPageNumber(), 3, Sort.by("dateRelease").descending());
        }
        blogList = this.blogService.findAll(pageableSortByDateRelease);
        ModelAndView modelAndView = new ModelAndView("blog/list");
        modelAndView.addObject("reverseSort", sort.equals("DESC") ? "ASC" : "DESC");
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

    @GetMapping("/blog/view-category")
    public ModelAndView viewCategory(Pageable pageable, @RequestParam Integer categoryId){
        Page<Blog> blogPage;
//        Category category = this.categoryService.findById(categoryId);
        blogPage = blogService.findAllByCategory_Id(categoryId, pageable);
        ModelAndView modelAndView = new ModelAndView("/blog/viewCategory");
        modelAndView.addObject("blogs", blogPage);
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

    @GetMapping("/blog/delete")
    public ModelAndView showDeleteForm(@RequestParam Integer id) {
        return new ModelAndView("blog/delete", "blogs", this.blogService.findById(id));
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
