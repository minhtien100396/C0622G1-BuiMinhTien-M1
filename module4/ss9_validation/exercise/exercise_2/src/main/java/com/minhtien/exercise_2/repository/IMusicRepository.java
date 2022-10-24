package com.minhtien.exercise_2.repository;

import com.minhtien.exercise_2.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicRepository extends JpaRepository<Music,Integer> {
}
