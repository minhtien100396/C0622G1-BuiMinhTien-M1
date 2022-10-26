package com.minhtien.book_oder.repository;

import com.minhtien.book_oder.model.Oder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOderRepository extends JpaRepository<Oder,Integer> {
    @Query(value = "select * from oder where code =:code",nativeQuery = true)
    Oder findByCode(@Param("code") int code);
}
