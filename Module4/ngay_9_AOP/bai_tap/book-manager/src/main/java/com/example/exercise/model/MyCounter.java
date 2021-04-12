package com.example.exercise.model;

import javax.persistence.*;

@Entity(name = "counter")
@Table
public class MyCounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer count;

    public MyCounter() {
    }

    public MyCounter(Integer count) {
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

//    public int increment() {
//        return count++;
//    }
}
