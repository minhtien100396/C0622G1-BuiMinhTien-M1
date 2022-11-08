package com.casestudy.demo.repository;

import com.casestudy.demo.model.AttachFacility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {
    @Query(value = "select af.* from `contract_detail` cd join `attach_facility` af on af.id = cd.attach_facility_id where cd.contract_id =:idContract", nativeQuery = true)
    Page<AttachFacility> getPageAttachFacility(@Param("idContract") int idContract, Pageable pageable);
}
