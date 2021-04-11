package com.example.exercise.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "products")
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;
    private String nameProduct;
    private Integer priceProduct;

    public Product() {
    }

    public Product(String nameProduct, Integer priceProduct) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Integer priceProduct) {
        this.priceProduct = priceProduct;
    }


//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof Product) {
//            Product product = (Product) obj;
//            if (this.idProduct.equals(product.idProduct)) {
//                return true;
//            }
//        }
//        return false;
//    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Product product = (Product) object;
        return Objects.equals(idProduct, product.idProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct);
    }
}
