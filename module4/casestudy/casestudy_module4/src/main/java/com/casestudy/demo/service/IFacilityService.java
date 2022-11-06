package com.casestudy.demo.service;

import com.casestudy.demo.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Page<Facility> findByStatus(String status, Pageable pageable);
    Facility findById(Integer id);
    Page<Facility> findByName(String name, String status, Pageable pageable);
    Page<Facility> findByFacilityTypeId(String facilityTypeId, String status, Pageable pageable);
    Page<Facility> findByNameAndFacilityTypeId(String name, String facilityTypeId, String status, Pageable pageable);
    void save(Facility facility);
}
