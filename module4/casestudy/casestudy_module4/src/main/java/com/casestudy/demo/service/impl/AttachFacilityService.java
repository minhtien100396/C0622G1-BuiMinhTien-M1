package com.casestudy.demo.service.impl;

import com.casestudy.demo.model.AttachFacility;
import com.casestudy.demo.repository.IAttachFacilityRepository;
import com.casestudy.demo.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository facilityRepository;

    @Override
    public List<AttachFacility> getList() {
        return facilityRepository.findAll();
    }

    @Override
    public Page<AttachFacility> getPage(Integer idContract, Pageable pageable) {
        return facilityRepository.getPageAttachFacility(idContract,pageable);
    }

    @Override
    public AttachFacility findAttachFacilityById(int attachFacilityId) {
        return facilityRepository.findById(attachFacilityId).orElse(null);
    }
}
