package com.casestudy.demo.dto;

import com.casestudy.demo.model.*;

import javax.validation.constraints.Null;
import java.util.Set;

public class ContractDto {
    private Integer id;
    private String startDate;
    private String endDate;
    private Double deposit;
    private Customer customer;
    private Facility facility;
    private Set<ContractDetail> contractDetails;
    private Employee employee;
    private Integer status = 1;
    private Double totalMoney;

    public ContractDto() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void getTotal(){
        totalMoney = facility.getCost();
        if (contractDetails!=null){
            for (ContractDetail item : contractDetails) {
                Integer q = item.getQuantity();
                AttachFacility c = item.getAttachFacility();
                if(item == null || c == null || q == null)
                    continue;
                totalMoney += q.intValue() * c.getCost();
            }

        }
    }
}