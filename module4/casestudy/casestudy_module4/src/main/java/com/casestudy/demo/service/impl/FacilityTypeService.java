package com.casestudy.demo.service.impl;

import com.casestudy.demo.model.FacilityType;
import com.casestudy.demo.repository.IFacilityTypeRepository;
import com.casestudy.demo.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Override
    public List<FacilityType> getList() {
        return facilityTypeRepository.findAll();
    }
}
