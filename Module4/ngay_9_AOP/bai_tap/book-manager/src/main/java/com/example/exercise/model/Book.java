package com.example.exercise.model;

import javax.persistence.*;

@Entity(name = "books")
@Table
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String bookCode;
    private String bookName;
    private Integer bookQuantity;
    private Integer countVisitTurn;

    public Book() {
    }

    public Book(String bookCode, String bookName, Integer bookQuantity) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.bookQuantity = bookQuantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(Integer bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public Integer getCountVisitTurn() {
        return countVisitTurn;
    }

    public void setCountVisitTurn(Integer countVisitTurn) {
        this.countVisitTurn = countVisitTurn;
    }

//    public int increment() {
//        return countVisitTurn++;
//    }
}
