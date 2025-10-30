package com.henix_erp.employee_service.controller;

import com.henix_erp.employee_service.entity.EmployeeLeavesHistory;
import com.henix_erp.employee_service.service.EmployeeLeavesHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/employee")
public class EmployeeLeavesHistoryController {

    EmployeeLeavesHistoryService employeeLeavesHistoryService;

    EmployeeLeavesHistoryController(EmployeeLeavesHistoryService employeeLeavesHistoryService) {
        this.employeeLeavesHistoryService = employeeLeavesHistoryService;
    }

    @PostMapping("/leave-history")
    public ResponseEntity<EmployeeLeavesHistory> create(@RequestBody EmployeeLeavesHistory employeeLeavesHistory) {
        EmployeeLeavesHistory leavesHistory = employeeLeavesHistoryService.create(employeeLeavesHistory);
        return ResponseEntity.status(HttpStatus.CREATED).body(leavesHistory);
    }

    @GetMapping("/{id}/leave-history")
    public ResponseEntity<List<EmployeeLeavesHistory>> getEmployeeLeavesHistory(@PathVariable int id) {
        List<EmployeeLeavesHistory> employeeLeavesHistory = employeeLeavesHistoryService.getEmployeeLeavesHistory(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeLeavesHistory);
    }
}
