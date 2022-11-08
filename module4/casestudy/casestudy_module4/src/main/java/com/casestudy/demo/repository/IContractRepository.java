package com.casestudy.demo.repository;

import com.casestudy.demo.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select * from contract where status = 1", nativeQuery = true)
    Page<Contract> getPage(Pageable pageable);

    @Query(value = "select ct.* from `customer` c join `contract` ct on c.id = ct.customer_id join `facility` f on f.id = ct.facility_id where ct.status =1 group by c.name order by c.name", nativeQuery = true)
    Page<Contract> getPageUsing(Pageable pageable);
}
