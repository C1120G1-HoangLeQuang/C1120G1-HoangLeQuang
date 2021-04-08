package com.codegym.demo;

import com.codegym.demo.aop.DemoAOP;
import com.codegym.demo.service.impl.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AOPConfig {

    @Bean
    public CustomerServiceImpl customerService () {
        return new CustomerServiceImpl();
    }

    @Bean
    public DemoAOP demoAOP() {
        return new DemoAOP();
    }
}
