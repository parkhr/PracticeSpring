package com.example.demo.domain.employee;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employee")
    public void createEmployee(@Valid @RequestBody CreateEmployeeRequest requestDto) {

    }

    @GetMapping("/employees")
    public List<EmployeeDto> findEmployees() {
        return employeeService.findEmployees();
    }

    @GetMapping("/employees/{firstName}")
    public List<EmployeeDto> firstEmployees(@PathVariable("firstName") String firstName) {
        return employeeService.findEmployees(firstName);
    }
}