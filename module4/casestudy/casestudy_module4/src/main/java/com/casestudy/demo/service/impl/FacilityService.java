package com.casestudy.demo.service.impl;

import com.casestudy.demo.model.Facility;
import com.casestudy.demo.repository.IFacilityRepository;
import com.casestudy.demo.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;


    @Override
    public Facility findById(Integer id) {
        return facilityRepository.findById(id).orElse(null);
    }




    @Override
    public Page<Facility> findByNameAndFacilityType(String name, String facilityType,  Pageable pageable) {
        return facilityRepository.findPageNameAndFacilityType(name, facilityType,  pageable);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public List<Facility> getList() {
        return facilityRepository.getList();
    }
}
