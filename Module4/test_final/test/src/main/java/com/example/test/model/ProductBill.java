package com.example.test.model;

import javax.persistence.*;

@Entity(name = "product_bill")
@Table
public class ProductBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_bill_id", nullable = false)
    private Integer productBillId;

    @Column(name = "buy_date", nullable = false)
    private String buyDate;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "total", nullable = false)
    private Integer total;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    public ProductBill() {
    }

    public ProductBill(String buyDate, Integer quantity, Integer total, Product product) {
        this.buyDate = buyDate;
        this.quantity = quantity;
        this.total = total;
        this.product = product;
    }

    public Integer getProductBillId() {
        return productBillId;
    }

    public void setProductBillId(Integer productBillId) {
        this.productBillId = productBillId;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
