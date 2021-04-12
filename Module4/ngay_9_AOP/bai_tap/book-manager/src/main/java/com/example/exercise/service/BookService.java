package com.example.exercise.service;

import com.example.exercise.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    void save(Book book);
    Book findById(Integer id);
    void saveBorrow(Book book) throws QuantityException;
    void saveReturn(Book book);
//    int increment(Book book);
}
