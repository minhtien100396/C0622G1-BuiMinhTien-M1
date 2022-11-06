package com.casestudy.demo.service.impl;

import com.casestudy.demo.model.Facility;
import com.casestudy.demo.repository.IFacilityRepository;
import com.casestudy.demo.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findByStatus(String status, Pageable pageable) {
        return facilityRepository.findPageStatus(status, pageable);
    }

    @Override
    public Facility findById(Integer id) {
        return facilityRepository.findById(id).orElse(null);
    }


    @Override
    public Page<Facility> findByName(String name, String status, Pageable pageable) {
        return facilityRepository.findPageName(name, status, pageable);
    }

    @Override
    public Page<Facility> findByFacilityTypeId(String facilityTypeId, String status, Pageable pageable) {
        return facilityRepository.findPageFacilityTypeId(facilityTypeId, status, pageable);
    }

    @Override
    public Page<Facility> findByNameAndFacilityTypeId(String name, String facilityTypeId, String status, Pageable pageable) {
        return facilityRepository.findPageNameAndFacilityTypeId(name, facilityTypeId, status, pageable);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }
}
