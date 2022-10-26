package com.minhtien.demo.repository;

import com.minhtien.demo.bean.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassRepository extends JpaRepository<ClassRoom,Integer> {

}
