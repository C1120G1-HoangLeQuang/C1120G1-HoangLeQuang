package com.example.casestudy.model.customer;

import com.example.casestudy.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity(name = "customer")
@Table
public class Customer {

    @Id
    @Column(name = "customer_id", nullable = false)
    private String cusId;
    @Column(name = "customer_name", nullable = false)
    private String cusName;
    @Column(name = "customer_birthday", nullable = false)
    private String cusBirthday;
    @Column(name = "customer_gender", nullable = false)
    private Integer cusGender;
    @Column(name = "customer_id_card", nullable = false)
    private String cusIdCard;
    @Column(name = "customer_phone", nullable = false)
    private String cusPhone;
    @Column(name = "customer_email", nullable = false)
    private String cusEmail;
    @Column(name = "customer_address", nullable = false)
    private String cusAddress;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", nullable = false, referencedColumnName = "customer_type_id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Contract> contracts;

    public Customer() {
    }

    public Customer(String cusId, String cusName, String cusBirthday, Integer cusGender, String cusIdCard, String cusPhone, String cusEmail, String cusAddress, CustomerType customerType, List<Contract> contracts) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.cusBirthday = cusBirthday;
        this.cusGender = cusGender;
        this.cusIdCard = cusIdCard;
        this.cusPhone = cusPhone;
        this.cusEmail = cusEmail;
        this.cusAddress = cusAddress;
        this.customerType = customerType;
        this.contracts = contracts;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusBirthday() {
        return cusBirthday;
    }

    public void setCusBirthday(String cusBirthday) {
        this.cusBirthday = cusBirthday;
    }

    public Integer getCusGender() {
        return cusGender;
    }

    public void setCusGender(Integer cusGender) {
        this.cusGender = cusGender;
    }

    public String getCusIdCard() {
        return cusIdCard;
    }

    public void setCusIdCard(String cusIdCard) {
        this.cusIdCard = cusIdCard;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
