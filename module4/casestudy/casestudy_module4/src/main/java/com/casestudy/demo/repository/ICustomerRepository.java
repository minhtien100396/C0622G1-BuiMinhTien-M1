package com.casestudy.demo.repository;

import com.casestudy.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select c.* from `customer` c join `customer_type` ct on c.customer_type_id = ct.id where  c.name like %:name% and c.email like %:email% and ct.name like %:customerType% and c.status =1", nativeQuery=true)
    Page<Customer> findByNameAndEmailAndCustomerTypeId(@Param("name") String name,
                                                       @Param("email") String email,
                                                       @Param("customerType") String customerType,
                                                       Pageable pageable);

}
