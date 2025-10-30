package com.henix_erp.employee_service.controller;

import com.henix_erp.employee_service.entity.EmployeeSkill;
import com.henix_erp.employee_service.service.EmployeeSkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2")
public class EmployeeSkillController {

    EmployeeSkillService employeeSkillService;

    EmployeeSkillController(EmployeeSkillService employeeSkillService) {
        this.employeeSkillService = employeeSkillService;
    }

    @PostMapping("/employee-skill")
    public ResponseEntity<EmployeeSkill> create(@RequestBody EmployeeSkill employeeSkill) {
        EmployeeSkill savedEmployeeSkill = employeeSkillService.create(employeeSkill);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployeeSkill);
    }

    @GetMapping("/employee-skills/{id}")
    public ResponseEntity<List<EmployeeSkill>> getEmployeeSkills(@PathVariable int id) {
        List<EmployeeSkill> employeeSkills = employeeSkillService.getEmployeeSkills(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeSkills);
    }
}
