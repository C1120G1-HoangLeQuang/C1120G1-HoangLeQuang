package com.example.test.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "product")
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_cost", nullable = false)
    private Integer productCost;

    @Column(name = "product_status", nullable = false)
    private String productStatus;

    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "product_type_id")
    private ProductType productType;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductBill> productBillList;

    public Product() {
    }

    public Product(String productName, Integer productCost, String productStatus, ProductType productType, List<ProductBill> productBillList) {
        this.productName = productName;
        this.productCost = productCost;
        this.productStatus = productStatus;
        this.productType = productType;
        this.productBillList = productBillList;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductCost() {
        return productCost;
    }

    public void setProductCost(Integer productCost) {
        this.productCost = productCost;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public List<ProductBill> getProductBillList() {
        return productBillList;
    }

    public void setProductBillList(List<ProductBill> productBillList) {
        this.productBillList = productBillList;
    }
}
