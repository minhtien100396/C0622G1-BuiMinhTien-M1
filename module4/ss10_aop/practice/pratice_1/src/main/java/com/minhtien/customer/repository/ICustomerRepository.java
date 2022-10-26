package com.minhtien.customer.repository;

import com.minhtien.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where last_name like :lastName",nativeQuery = true)
    List<Customer> findByName(@Param("lastName") String lastName);
}
