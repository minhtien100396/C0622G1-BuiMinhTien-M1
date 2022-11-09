package com.casestudy.demo.service;

import com.casestudy.demo.dto.IContractDto;
import com.casestudy.demo.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContracService {
    Page<Contract> getPage(Pageable pageable);

    void save(Contract contract);

    Page<Contract> getPageUsing(Pageable pageable);

    Contract findContractById(int contractId);

    Page<IContractDto> getContractUsing(Pageable pageable);

}
