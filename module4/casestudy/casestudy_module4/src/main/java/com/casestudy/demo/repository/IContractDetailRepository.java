package com.casestudy.demo.repository;

import com.casestudy.demo.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {

    @Query(value = "select * from contract_detail where contract_id =:contractId", nativeQuery = true)
    List<ContractDetail> findByContractId(@Param("contractId") int contractId);

}
