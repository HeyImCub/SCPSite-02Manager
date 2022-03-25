package com.cub.idk.repository;

import com.cub.idk.model.Employee;
import com.cub.idk.model.SCPentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    @Query(value="SELECT * FROM employees p WHERE p.IdNum LIKE %:keyword%", nativeQuery = true)
    public List<Employee> search(@Param("keyword") String keyword);



}