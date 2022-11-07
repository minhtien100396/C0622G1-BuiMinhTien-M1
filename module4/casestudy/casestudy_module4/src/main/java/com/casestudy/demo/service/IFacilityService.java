package com.casestudy.demo.service;

import com.casestudy.demo.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Facility findById(Integer id);
    Page<Facility> findByNameAndFacilityType(String name, String facilityType,  Pageable pageable);
    void save(Facility facility);
}
