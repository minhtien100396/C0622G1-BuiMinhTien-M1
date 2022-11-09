package com.casestudy.demo.dto;

import com.casestudy.demo.model.Contract;
import com.casestudy.demo.model.FacilityType;
import com.casestudy.demo.model.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class FacilityDto implements Validator {
    private Integer id;
    @NotBlank(message = "Name cannot be left blank")
    private String name;
    @NotNull(message = "Area cannot be left blank")
    private Integer area;
    @NotNull(message = "Cost cannot be left blank")
    private Double cost;
    @NotNull(message = "Max People cannot be left blank")
    private Integer maxPeople;
    @NotBlank(message = "Standard Room cannot be left blank")
    private String standardRoom;
    @NotBlank(message = "Description Other Convenience cannot be left blank")
    private String descriptionOtherConvenience;
    @NotNull(message = "Pool Area cannot be left blank")
    private Double poolArea;
    @NotNull(message = "Number Of Floors cannot be left blank")
    private Integer numberOfFloors;
    private Integer status = 1;
    @NotBlank(message = "Facility Free cannot be left blank")
    private String facilityFree;
    private FacilityType facilityType;
    private RentType rentType;
    private Set<Contract> contracts;

    public FacilityDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
        if (facilityDto.area == null) {
            errors.rejectValue("area", "area.errors", "Area must be positive");
        } else if (facilityDto.area <= 0) {
            errors.rejectValue("area", "area.errors", "Area must be positive");
        }

        if (facilityDto.cost == null) {
            errors.rejectValue("cost", "cost.errors", "Cost must be positive");
        } else if (facilityDto.cost <= 0) {
            errors.rejectValue("cost", "cost.errors", "Cost must be positive");
        }
        if (facilityDto.maxPeople == null) {
            errors.rejectValue("maxPeople", "maxPeople.errors", "Max People must be positive");
        } else if (facilityDto.maxPeople <= 0) {
            errors.rejectValue("maxPeople", "maxPeople.errors", "Max People must be positive");
        }

        if (facilityDto.poolArea == null) {
            errors.rejectValue("poolArea", "poolArea.errors", "Pool Area must be positive");
        } else if (facilityDto.poolArea <= 0) {
            errors.rejectValue("poolArea", "poolArea.errors", "Pool Area must be positive");
        }

        if (facilityDto.numberOfFloors == null) {
            errors.rejectValue("numberOfFloors", "numberOfFloors.errors", "Number Of Floors must be positive");
        } else if (facilityDto.numberOfFloors <= 0) {
            errors.rejectValue("numberOfFloors", "numberOfFloors.errors", "Number Of Floors must be positive");
        }
    }
}
