package com.example.casestudy.model.service;

import javax.persistence.*;
import java.util.List;

@Entity(name = "service_type")
@Table
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id", nullable = false)
    private Integer serTypeId;
    @Column(name = "service_type_name", nullable = false)
    private String serTypeName;

    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.ALL)
    List<Service> services;

    public ServiceType() {
    }

    public ServiceType(String serTypeName, List<Service> services) {
        this.serTypeName = serTypeName;
        this.services = services;
    }

    public Integer getSerTypeId() {
        return serTypeId;
    }

    public void setSerTypeId(Integer serTypeId) {
        this.serTypeId = serTypeId;
    }

    public String getSerTypeName() {
        return serTypeName;
    }

    public void setSerTypeName(String serTypeName) {
        this.serTypeName = serTypeName;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
