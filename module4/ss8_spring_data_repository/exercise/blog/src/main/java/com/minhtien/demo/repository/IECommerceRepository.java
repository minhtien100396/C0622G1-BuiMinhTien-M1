package com.minhtien.demo.repository;

import com.minhtien.demo.model.ECommerce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IECommerceRepository extends JpaRepository<ECommerce, Integer> {
}
