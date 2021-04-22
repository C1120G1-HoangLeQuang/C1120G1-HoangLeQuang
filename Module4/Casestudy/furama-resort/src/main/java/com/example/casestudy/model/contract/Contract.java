package com.example.casestudy.model.contract;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.model.employee.Employee;
import com.example.casestudy.model.service.Service;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "contract")
@Table
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id", nullable = false)
    private Integer conId;
    @Column(name = "contract_start_date", nullable = false)
    private String conStartDate;
    @Column(name = "contract_end_date", nullable = false)
    private String conEndDate;
    @Column(name = "contract_deposit", nullable = false)
    private Double conDeposit;
    @Column(name = "contract_total", nullable = false)
    private Double conTotal;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    Set<ContractDetail> contractDetails;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false, referencedColumnName = "service_id")
    private Service service;

    public Contract() {
    }

    public Contract(String conStartDate, String conEndDate, Double conDeposit, Double conTotal, Set<ContractDetail> contractDetails, Employee employee, Customer customer, Service service) {
        this.conStartDate = conStartDate;
        this.conEndDate = conEndDate;
        this.conDeposit = conDeposit;
        this.conTotal = conTotal;
        this.contractDetails = contractDetails;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getConStartDate() {
        return conStartDate;
    }

    public void setConStartDate(String conStartDate) {
        this.conStartDate = conStartDate;
    }

    public String getConEndDate() {
        return conEndDate;
    }

    public void setConEndDate(String conEndDate) {
        this.conEndDate = conEndDate;
    }

    public Double getConDeposit() {
        return conDeposit;
    }

    public void setConDeposit(Double conDeposit) {
        this.conDeposit = conDeposit;
    }

    public Double getConTotal() {
        return conTotal;
    }

    public void setConTotal(Double conTotal) {
        this.conTotal = conTotal;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
