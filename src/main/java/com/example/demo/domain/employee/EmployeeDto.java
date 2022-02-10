package com.example.demo.domain.employee;

import lombok.Builder;
import lombok.Getter;

@Getter
public class EmployeeDto {
    private Long empNo;

    @Builder
    public EmployeeDto(Long empNo) {
        this.empNo = empNo;
    }
}
