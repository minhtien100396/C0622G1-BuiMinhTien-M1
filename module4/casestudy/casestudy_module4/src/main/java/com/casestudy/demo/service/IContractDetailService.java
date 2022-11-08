package com.casestudy.demo.service;

import com.casestudy.demo.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService {
    void save(ContractDetail contractDetail);

    List<ContractDetail> findByContractId(int contractId);

    Page<ContractDetail> findByContract(int contractId, Pageable pageable);
}
