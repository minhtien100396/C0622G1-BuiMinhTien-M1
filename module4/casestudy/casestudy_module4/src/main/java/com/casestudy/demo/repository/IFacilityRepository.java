package com.casestudy.demo.repository;

import com.casestudy.demo.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    @Query(value = "select * from facility where facility.status =:status",nativeQuery = true)
    Page<Facility> findPageStatus(@Param("status") String status,
                                  Pageable pageable);

    @Query(value = "select * from facility where name like %:name% and facility_type_id =:facilityTypeId and facility.status =:status",nativeQuery = true)
    Page<Facility> findPageNameAndFacilityTypeId(@Param("name") String name,
                                                 @Param("facilityTypeId") String facilityTypeId,
                                                 @Param("status") String status,
                                                 Pageable pageable);

    @Query(value = "select * from facility where facility_type_id =:facilityTypeId and facility.status =:status",nativeQuery = true)
    Page<Facility> findPageFacilityTypeId(@Param("facilityTypeId") String facilityTypeId,
                                          @Param("status") String status,
                                          Pageable pageable);

    @Query(value = "select * from facility where name like %:name% and facility.status =:status",nativeQuery = true)
    Page<Facility> findPageName(@Param("name") String name,
                                                 @Param("status") String status,
                                                 Pageable pageable);
}
