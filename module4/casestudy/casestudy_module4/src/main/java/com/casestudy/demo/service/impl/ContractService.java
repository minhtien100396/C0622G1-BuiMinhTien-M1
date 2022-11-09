package com.casestudy.demo.service.impl;

import com.casestudy.demo.dto.IContractDto;
import com.casestudy.demo.model.AttachFacility;
import com.casestudy.demo.model.Contract;
import com.casestudy.demo.model.ContractDetail;
import com.casestudy.demo.repository.IContractRepository;
import com.casestudy.demo.service.IContracService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContracService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<Contract> getPage(Pageable pageable) {
        return contractRepository.getPage(pageable);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Page<Contract> getPageUsing(Pageable pageable) {
        return contractRepository.getPageUsing(pageable);
    }

    @Override
    public Contract findContractById(int contractId) {
        return contractRepository.findById(contractId).orElse(null);
    }

    @Override
    public Page<IContractDto> getContractUsing(Pageable pageable) {
        return contractRepository.getContractUsing(pageable);
    }

}
