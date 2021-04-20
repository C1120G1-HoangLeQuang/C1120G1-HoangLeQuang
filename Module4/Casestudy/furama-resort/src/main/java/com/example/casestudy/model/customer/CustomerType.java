package com.example.casestudy.model.customer;

import com.example.casestudy.model.customer.Customer;

import javax.persistence.*;
import java.util.List;

@Entity(name = "customer_type")
@Table
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_type_id", nullable = false)
    private Integer cusTypeId;

    @Column(name = "customer_type_name", nullable = false)
    private String cusTypeName;

    @OneToMany(mappedBy = "customerType", cascade = CascadeType.ALL)
    List<Customer> customers;

    public CustomerType() {
    }

    public CustomerType(String cusTypeName, List<Customer> customers) {
        this.cusTypeName = cusTypeName;
        this.customers = customers;
    }

    public Integer getCusTypeId() {
        return cusTypeId;
    }

    public void setCusTypeId(Integer cusTypeId) {
        this.cusTypeId = cusTypeId;
    }

    public String getCusTypeName() {
        return cusTypeName;
    }

    public void setCusTypeName(String cusTypeName) {
        this.cusTypeName = cusTypeName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
