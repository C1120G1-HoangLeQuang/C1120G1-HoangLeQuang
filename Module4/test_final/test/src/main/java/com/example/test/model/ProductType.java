package com.example.test.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "product_type")
@Table
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id", nullable = false)
    private Integer productTypeId;

    @Column(name = "product_type_name", nullable = false)
    private String productTypeName;

    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
    List<Product> productList;

    public ProductType() {
    }

    public ProductType(String productTypeName, List<Product> productList) {
        this.productTypeName = productTypeName;
        this.productList = productList;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
