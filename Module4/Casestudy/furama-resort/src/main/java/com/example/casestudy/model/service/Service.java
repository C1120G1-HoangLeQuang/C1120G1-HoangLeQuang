package com.example.casestudy.model.service;

import com.example.casestudy.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity(name = "service")
@Table
public class Service {

    @Id
    @Column(name = "service_id", nullable = false)
    private String serId;
    @Column(name = "service_name", nullable = false)
    private String serName;
    @Column(name = "service_area", nullable = false)
    private Integer serArea;
    @Column(name = "service_max_people", nullable = false)
    private Integer serMaxPeople;
    @Column(name = "service_cost", nullable = false)
    private Integer serCost;
    @Column(name = "standard_room")
    private String standardRoom;
    @Column(name = "description_other_convenience")
    private String otherService;
    @Column(name = "pool_area")
    private Double poolArea;
    @Column(name = "number_of_floors")
    private Integer numFloor;

    @ManyToOne
    @JoinColumn(name = "service_type_id", nullable = false, referencedColumnName = "service_type_id")
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", nullable = false, referencedColumnName = "rent_type_id")
    private RentType rentType;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<Contract> contracts;

    public Service() {
    }

    public Service(String serId, String serName, Integer serArea, Integer serMaxPeople, Integer serCost, String standardRoom, String otherService, Double poolArea, Integer numFloor, ServiceType serviceType, RentType rentType, List<Contract> contracts) {
        this.serId = serId;
        this.serName = serName;
        this.serArea = serArea;
        this.serMaxPeople = serMaxPeople;
        this.serCost = serCost;
        this.standardRoom = standardRoom;
        this.otherService = otherService;
        this.poolArea = poolArea;
        this.numFloor = numFloor;
        this.serviceType = serviceType;
        this.rentType = rentType;
        this.contracts = contracts;
    }

    public String getSerId() {
        return serId;
    }

    public void setSerId(String serId) {
        this.serId = serId;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public Integer getSerArea() {
        return serArea;
    }

    public void setSerArea(Integer serArea) {
        this.serArea = serArea;
    }

    public Integer getSerMaxPeople() {
        return serMaxPeople;
    }

    public void setSerMaxPeople(Integer serMaxPeople) {
        this.serMaxPeople = serMaxPeople;
    }

    public Integer getSerCost() {
        return serCost;
    }

    public void setSerCost(Integer serCost) {
        this.serCost = serCost;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getOtherService() {
        return otherService;
    }

    public void setOtherService(String otherService) {
        this.otherService = otherService;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumFloor() {
        return numFloor;
    }

    public void setNumFloor(Integer numFloor) {
        this.numFloor = numFloor;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
