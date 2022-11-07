package com.casestudy.demo.repository;

import com.casestudy.demo.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    @Query(value = "select f.* from `facility` f join `facility_type` ft on f.facility_type_id = ft.id  where f.name like %:name% and ft.name like %:facilityType% and f.status =1",nativeQuery = true)
    Page<Facility> findPageNameAndFacilityType(@Param("name") String name,
                                                 @Param("facilityType") String facilityType,
                                                 Pageable pageable);

}
