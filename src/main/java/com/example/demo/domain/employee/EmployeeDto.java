package com.example.demo.domain.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

public class EmployeeDto {

    public static class SaveRequest {
        //    @NotBlank(message =  "firstName 을 입력해주세요.")
        //    private String firstName;
        //
        //    @NotBlank(message =  "lastName 을 입력해주세요.")
        //    private String lastName;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class EmployeeInfoResponse {
        private Long empNo;
        private LocalDate birthDate;
        private String firstName;
        private String lastName;
        private Gender gender;
        private LocalDate hireDate;
    }
}
