package com.example.exercise.aop;

import com.example.exercise.service.MyCounterService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

@Aspect
public class BookAOP {
    @Autowired
    MyCounterService myCounterService;

    @After("execution(* com.example.exercise.controller.BookController.saveBook(..))")
    public void afterBorrow(JoinPoint joinPoint1) {
        System.out.println("Borrow book: " + joinPoint1.getSignature().getName());
    }

    @After("execution(* com.example.exercise.controller.BookController.saveReturnBook(..))")
    public void afterReturn(JoinPoint joinPoint2) {
        System.out.println("Return Book:  " + joinPoint2.getSignature().getName());
    }

    @After("execution(* com.example.exercise.controller.BookController.getBookList())")
    public void countTurn(JoinPoint joinPoint3) {
        myCounterService.getVisitTurn(1);
        System.out.println("Visit Turn: " + myCounterService.VisitTurnNumber(1));
    }

    @AfterThrowing(value = "execution(* com.example.exercise.service.impl.BookServiceImpl.*())", throwing = "e")
    public void afterThrowingCallMethod(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[System] has error: %s.%s%s: %s", className, method, args, e.getMessage()));
    }
}
