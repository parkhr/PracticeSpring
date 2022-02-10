package com.example.demo.domain.employee;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_no", nullable = false)
    private Long empNo;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    public boolean equalFirstName(String firstName) {
        return this.firstName.equals(firstName);
    }

    public EmployeeDto toFindEmployeeDto() {
        return EmployeeDto.builder()
                .empNo(this.empNo)
                .birthDate(this.birthDate)
                .firstName(this.firstName)
                .lastName(this.lastName)
                .gender(this.gender)
                .hireDate(this.hireDate)
                .build();
    }
}