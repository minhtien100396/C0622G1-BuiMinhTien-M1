package com.casestudy.demo.repository;

import com.casestudy.demo.model.AttachFacility;
import com.casestudy.demo.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "select * from contract where status = 1", nativeQuery = true)
    Page<Contract> getPage(Pageable pageable);


}
