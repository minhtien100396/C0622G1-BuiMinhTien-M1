package com.casestudy.demo.repository;

import com.casestudy.demo.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenderRepository extends JpaRepository<Gender,Integer> {
}
