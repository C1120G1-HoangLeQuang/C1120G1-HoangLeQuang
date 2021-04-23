package com.example.casestudy.model.customer;

import com.example.casestudy.model.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity(name = "customer")
@Table
public class Customer {

    @Id
    @Column(name = "customer_id", nullable = false)
    @Pattern(regexp = "^KH-[0-9]{4}$", message = "Information is not correct by format (KH-xxxx)")
    private String cusId;

    @Column(name = "customer_name", nullable = false)
    private String cusName;

    @Column(name = "customer_birthday", nullable = false)
    private String cusBirthday;

    @Column(name = "customer_gender", nullable = false)
    private Integer cusGender;

    @Column(name = "customer_id_card", nullable = false)
    @Pattern(regexp = "^([\\d]{9})|(^[\\d]{12}$)$", message = "Information is not correct by format (xxxxxxxxx) | (xxxxxxxxxxxx)")
    private String cusIdCard;

    @Column(name = "customer_phone", nullable = false)
    @Pattern(regexp = "^((090|091)([\\d]{7}))|((\\(\\+84\\))(90([\\d]{7})))|((\\(\\+84\\))(91([\\d]{7})))$",
            message = "Information is not correct by format (090xxxxxxx) | (091xxxxxxx) | ((+84)90xxxxxxx) | ((+84)91xxxxxxx)")
    private String cusPhone;

    @Column(name = "customer_email", nullable = false)
    @Email(message = "Information is not correct by format(abc@abc.abc)")
    private String cusEmail;

    @Column(name = "customer_address", nullable = false)
    private String cusAddress;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", nullable = false, referencedColumnName = "customer_type_id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
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
