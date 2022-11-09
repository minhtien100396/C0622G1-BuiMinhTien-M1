package com.casestudy.demo.dto;

import com.casestudy.demo.model.AttachFacility;
import com.casestudy.demo.model.Contract;

import javax.validation.constraints.NotBlank;

public class ContractDetailDto {
    private Integer id;

    @NotBlank(message = "Quantity cannot be left blank")
    private Integer quantity;
    private Contract contract;
    private AttachFacility attachFacility;
    private Integer status = 1;

    public ContractDetailDto() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }
}
