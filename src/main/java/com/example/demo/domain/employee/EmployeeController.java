package com.example.demo.domain.employee;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employee")
    public void createEmployee(@Valid @RequestBody EmployeeDto.SaveRequest requestDto) {

    }

    @GetMapping("/employees")
    public List<EmployeeDto.EmployeeInfoResponse> findEmployees() {
        return employeeService.findEmployees();
    }

    @GetMapping("/employees/{firstName}")
    public List<EmployeeDto.EmployeeInfoResponse> firstEmployees(@PathVariable("firstName") String firstName) {
        return employeeService.findEmployees(firstName);
    }

}