package com.example.model;

public class Product {

    private int id;
    private String name;
    private int price;
    private String nationality;

    public Product() {

    }

    public Product(int id, String name, int price, String nationality) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
