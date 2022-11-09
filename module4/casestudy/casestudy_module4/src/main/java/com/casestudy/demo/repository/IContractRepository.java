package com.casestudy.demo.repository;

import com.casestudy.demo.dto.IContractDto;
import com.casestudy.demo.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select * from contract where status = 1", nativeQuery = true)
    Page<Contract> getPage(Pageable pageable);

    @Query(value = "select ct.* from `customer` c join `contract` ct on c.id = ct.customer_id join `facility` f on f.id = ct.facility_id where ct.status =1 order by c.name", nativeQuery = true)
    Page<Contract> getPageUsing(Pageable pageable);

    @Query(value = "select customer.id customerId, customer.name customerName,contract.start_date startDate,contract.end_date endDate,GROUP_CONCAT(facility.name) as facilityList from `contract` join customer on contract.customer_id = customer.id join `facility` on contract.facility_id = facility.id group by customer.name ", nativeQuery = true)
    Page<IContractDto> getContractUsing(Pageable pageable);

}
