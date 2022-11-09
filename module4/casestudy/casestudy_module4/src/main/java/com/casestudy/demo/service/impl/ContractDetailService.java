package com.casestudy.demo.service.impl;

import com.casestudy.demo.model.ContractDetail;
import com.casestudy.demo.repository.IContractDetailRepository;
import com.casestudy.demo.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> findByContractId(int contractId) {
        return contractDetailRepository.findByContractId(contractId);
    }

    @Override
    public ContractDetail findById(int id) {
        return contractDetailRepository.findById(id).get();
    }

    @Override
    public ContractDetail findContractDetailByContractIdAndAttachFacilityId(int contractId, int attachFacilityId) {
        return contractDetailRepository.findContractDetailByContractIdAndAttachFacilityId(contractId,attachFacilityId);
    }

    @Override
    public List<ContractDetail> findByCustomerId(int customerId) {
        return contractDetailRepository.findByCustomerId(customerId);
    }

}