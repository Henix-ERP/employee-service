package com.henix_erp.employee_service.controller;

import com.henix_erp.employee_service.entity.Employee;
import com.henix_erp.employee_service.entity.EmployeeLeaves;
import com.henix_erp.employee_service.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class EmployeeController {

    EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.create(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> get(@PathVariable int id) {
        Employee employee = employeeService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> employees = employeeService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }
}
