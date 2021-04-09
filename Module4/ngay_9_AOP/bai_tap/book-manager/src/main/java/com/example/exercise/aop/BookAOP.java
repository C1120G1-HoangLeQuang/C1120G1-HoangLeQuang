package com.example.exercise.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class BookAOP {

    @After("execution(* com.example.exercise.controller.BookController.*(..))")
    public void afterCallMethod(JoinPoint joinPoint) {
        System.out.println("Visit Turn Library: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = "execution(* com.example.exercise.service.impl.BookServiceImpl.*())", throwing = "e")
    public void afterThrowingCallMethod(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[System] has error: %s.%s%s: %s", className, method, args, e.getMessage()));
    }
}
