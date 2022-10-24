package com.minhtien.exercise.repository;

import com.minhtien.exercise.model.Catagory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICatagoryRepository extends JpaRepository<Catagory,Integer> {
}
