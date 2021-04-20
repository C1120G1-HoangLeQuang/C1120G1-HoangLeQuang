package com.example.casestudy.model.service;

import javax.persistence.*;
import java.util.List;

@Entity(name = "rent_type")
@Table
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_type_id", nullable = false)
    private Integer rentTypeId;
    @Column(name = "rent_type_name", nullable = false)
    private String rentTypeName;
    @Column(name = "rent_type_cost", nullable = false)
    private Integer rentTypeCost;

    @OneToMany(mappedBy = "rentType", cascade = CascadeType.ALL)
    List<Service> services;

    public RentType() {
    }

    public RentType(String rentTypeName, Integer rentTypeCost, List<Service> services) {
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
        this.services = services;
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public Integer getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(Integer rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
