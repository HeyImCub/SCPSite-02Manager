package com.cub.idk.repository;

import com.cub.idk.model.Employee;
import com.cub.idk.model.SCPentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SCPentityrepository extends JpaRepository<SCPentity, Long> {
    @Query(value="SELECT * FROM SCPEntities p WHERE p.first_name LIKE %:keyword%", nativeQuery = true)
    public List<SCPentity> search(@Param("keyword") String keyword);



}
