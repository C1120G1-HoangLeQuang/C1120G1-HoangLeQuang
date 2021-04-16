package com.example.blog.repository;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByOrderByDateReleaseAsc(Pageable pageable);
    Page<Blog> findAllByNameBlogContaining (String nameBlog, Pageable pageable);
    Page<Blog> findAllByCategory_Id(Integer categoryId, Pageable pageable);
    List<Blog> findAllByNameBlogContaining (String nameBlog);
}
