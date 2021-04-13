package com.example.blog.service.impl;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.repository.BlogRepository;
import com.example.blog.service.BlogService;
import com.example.blog.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() == null) {
            blog.setDateRelease(DateUtil.getCurrentDate());
        }
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> findAllByOrderByDateReleaseAsc(Pageable pageable) {
        return blogRepository.findAllByOrderByDateReleaseAsc(pageable);
    }

    @Override
    public Page<Blog> findAllByNameBlogContaining(String nameBlog, Pageable pageable) {
        return blogRepository.findAllByNameBlogContaining(nameBlog, pageable);
    }

    @Override
    public Page<Blog> findAllByCategory_Id(Integer categoryName, Pageable pageable) {
        return blogRepository.findAllByCategory_Id(categoryName, pageable);
    }


}
