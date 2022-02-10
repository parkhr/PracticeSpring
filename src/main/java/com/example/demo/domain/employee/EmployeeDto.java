package com.example.demo.domain.employee;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EmployeeDto {
    private Long empNo;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate hireDate;

    @Builder
    public EmployeeDto(Long empNo, LocalDate birthDate, String firstName, String lastName, Gender gender, LocalDate hireDate) {
        this.empNo = empNo;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.hireDate = hireDate;
    }
}
