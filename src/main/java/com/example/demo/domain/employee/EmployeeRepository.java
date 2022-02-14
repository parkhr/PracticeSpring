package com.example.demo.domain.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT m FROM Employee m WHERE m.firstName = :firstName")
    List<Employee> findByFirstName(@Param("firstName") String firstName);
}