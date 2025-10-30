package com.henix_erp.employee_service.controller;

import com.henix_erp.employee_service.entity.EmployeeLeaves;
import com.henix_erp.employee_service.service.EmployeeLeavesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/employee")
public class EmployeeLeavesController {

    EmployeeLeavesService employeeLeavesService;

    EmployeeLeavesController(EmployeeLeavesService employeeLeavesService) {
        this.employeeLeavesService = employeeLeavesService;
    }

    @PostMapping("/leave")
    public ResponseEntity<EmployeeLeaves> create(@RequestBody EmployeeLeaves employeeLeaves) {
        EmployeeLeaves savedEmployeeLeaves = employeeLeavesService.create(employeeLeaves);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployeeLeaves);
    }

    @GetMapping("/{id}/leave")
    public ResponseEntity<EmployeeLeaves> getEmployeeLeaves(@PathVariable int id) {
        EmployeeLeaves employeeLeaves = employeeLeavesService.getEmployeeLeaves(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeLeaves);
    }
}
