package com.example.casestudy.model.contract;

import javax.persistence.*;

@Entity(name = "contract_detail")
@Table
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id", nullable = false)
    private Integer conDetailId;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "attach_service_id", nullable = false, referencedColumnName = "attach_service_id")
    private AttachService attachService;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false, referencedColumnName = "contract_id")
    private Contract contract;

    public ContractDetail() {
    }

    public ContractDetail(Integer quantity, AttachService attachService, Contract contract) {
        this.quantity = quantity;
        this.attachService = attachService;
        this.contract = contract;
    }

    public Integer getConDetailId() {
        return conDetailId;
    }

    public void setConDetailId(Integer conDetailId) {
        this.conDetailId = conDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
