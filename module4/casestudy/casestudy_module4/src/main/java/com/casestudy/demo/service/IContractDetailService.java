package com.casestudy.demo.service;

import com.casestudy.demo.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService {
    void save(ContractDetail contractDetail);

    List<ContractDetail> findByContractId(int contractId);

    ContractDetail findById(int id);

    ContractDetail findContractDetailByContractIdAndAttachFacilityId(int contractId, int attachFacilityId);

    List<ContractDetail> findByCustomerId(int customerId);
}
