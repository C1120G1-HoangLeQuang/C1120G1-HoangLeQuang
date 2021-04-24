package com.example.casestudy.model.contract;

import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.List;

@Entity(name = "attach_service")
@Table
public class AttachService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_service_id", nullable = false)
    private Integer attachSerId;
    @Column(name = "attach_service_name", nullable = false)
    private String attachSerName;
    @Column(name = "attach_service_cost", nullable = false)
    private String attachSerCost;
    @Column(name = "attach_service_unit", nullable = false)
    private Integer attachSerUnit;
    @Column(name = "attach_service_status", nullable = false)
    private String attachSerStatus;

    @OneToMany(mappedBy = "attachService", cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetails;


    public AttachService() {
    }

    public AttachService(String attachSerName, String attachSerCost, Integer attachSerUnit, String attachSerStatus, List<ContractDetail> contractDetails) {
        this.attachSerName = attachSerName;
        this.attachSerCost = attachSerCost;
        this.attachSerUnit = attachSerUnit;
        this.attachSerStatus = attachSerStatus;
        this.contractDetails = contractDetails;
    }

    public Integer getAttachSerId() {
        return attachSerId;
    }

    public void setAttachSerId(Integer attachSerId) {
        this.attachSerId = attachSerId;
    }

    public String getAttachSerName() {
        return attachSerName;
    }

    public void setAttachSerName(String attachSerName) {
        this.attachSerName = attachSerName;
    }

    public String getAttachSerCost() {
        return attachSerCost;
    }

    public void setAttachSerCost(String attachSerCost) {
        this.attachSerCost = attachSerCost;
    }

    public Integer getAttachSerUnit() {
        return attachSerUnit;
    }

    public void setAttachSerUnit(Integer attachSerUnit) {
        this.attachSerUnit = attachSerUnit;
    }

    public String getAttachSerStatus() {
        return attachSerStatus;
    }

    public void setAttachSerStatus(String attachSerStatus) {
        this.attachSerStatus = attachSerStatus;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
