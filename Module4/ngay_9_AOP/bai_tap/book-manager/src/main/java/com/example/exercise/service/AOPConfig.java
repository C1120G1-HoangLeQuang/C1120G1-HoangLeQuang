package com.example.exercise.service;

import com.example.exercise.aop.BookAOP;
import com.example.exercise.service.impl.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AOPConfig {

    @Bean
    public BookServiceImpl bookService() {
        return new BookServiceImpl();
    }

    @Bean
    public BookAOP bookAOP() {
        return new BookAOP();
    }
}
