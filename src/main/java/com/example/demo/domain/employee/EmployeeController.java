package com.example.demo.domain.employee;

import com.example.demo.common.ResponseBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @Operation(summary = "test hello", description = "hello api example")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK !!"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST !!"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND !!"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
    })
    @PostMapping("/employee")
    public void createEmployee(@Valid @RequestBody EmployeeDto.SaveRequest requestDto) {

    }

    @GetMapping("/employees")
    public ResponseEntity findEmployees() {
        return ResponseEntity.ok(ResponseBody.builder()
                                    .code(HttpStatus.OK.value())
                                    .data(employeeService.findEmployees())
                                    .build());
    }

    @GetMapping("/employees/{firstName}")
    public List<EmployeeDto.EmployeeInfoResponse> firstEmployees(@PathVariable("firstName") String firstName) throws Exception {
        throw new RuntimeException("bad request");
//        return employeeService.findEmployees(firstName);
    }
}