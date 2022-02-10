package com.example.demo.domain.employee;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_no", nullable = false)
    private Long empNo;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    public boolean equalFirstName(String firstName) {
        return this.firstName.equals(firstName);
    }

    public EmployeeDto toFindEmployeeDto() {
        return EmployeeDto.builder()
                .empNo(this.empNo)
                .build();
    }
}