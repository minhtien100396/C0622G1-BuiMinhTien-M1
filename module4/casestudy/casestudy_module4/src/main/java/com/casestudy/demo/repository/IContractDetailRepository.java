package com.casestudy.demo.repository;

import com.casestudy.demo.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {

    @Query(value = "select * from contract_detail where contract_id =:contractId", nativeQuery = true)
    List<ContractDetail> findByContractId(@Param("contractId") int contractId);

    @Query(value = "select * from contract_detail where contract_id =:contractId and attach_facility_id =:attachFacilityId", nativeQuery = true)
    ContractDetail findContractDetailByContractIdAndAttachFacilityId(@Param("contractId") int contractId,
                                                                     @Param("attachFacilityId") int attachFacilityId);

    @Query(value = "select cd.* from customer c join contract ct on c.id = ct.customer_id join contract_detail cd on cd.contract_id = ct.id join attach_facility af on cd.attach_facility_id = af.id where c.id =:customerId ", nativeQuery = true)
    List<ContractDetail> findByCustomerId(@Param("customerId") int customerId);
}
