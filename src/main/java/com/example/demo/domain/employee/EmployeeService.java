package com.example.demo.domain.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<EmployeeDto> findEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .filter(e -> e.equalFirstName("Mary"))
                .map(Employee::toFindEmployeeDto).collect(Collectors.toList());
    }

    public List<EmployeeDto> findEmployees(String firstName) {
        List<Employee> employees = employeeRepository.findByFirstName(firstName);

        return employees.stream()
                .map(Employee::toFindEmployeeDto).collect(Collectors.toList());
    }
}