package com.casestudy.demo.service;

import com.casestudy.demo.model.AttachFacility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> getList();

    Page<AttachFacility> getPage(Integer idContract, Pageable pageable);

    AttachFacility findAttachFacilityById(int attachFacilityId);
}
