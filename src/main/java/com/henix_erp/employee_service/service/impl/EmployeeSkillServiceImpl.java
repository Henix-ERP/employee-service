package com.henix_erp.employee_service.service.impl;

import com.henix_erp.employee_service.entity.Employee;
import com.henix_erp.employee_service.entity.EmployeeSkill;
import com.henix_erp.employee_service.entity.Skill;
import com.henix_erp.employee_service.repository.EmployeeSkillRepository;
import com.henix_erp.employee_service.service.EmployeeService;
import com.henix_erp.employee_service.service.EmployeeSkillService;
import com.henix_erp.employee_service.service.SkillService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    EmployeeSkillRepository employeeSkillRepository;
    EmployeeService employeeService;
    SkillService skillService;

    EmployeeSkillServiceImpl(
            EmployeeSkillRepository employeeSkillRepository,
            EmployeeService employeeService,
            SkillService skillService
    ) {
        this.employeeSkillRepository = employeeSkillRepository;
        this.employeeService = employeeService;
        this.skillService = skillService;
    }

    @Override
    public EmployeeSkill create(EmployeeSkill employeeSkill) {
        Employee employee = employeeService.get(employeeSkill.getEmployeeId());
        Skill skill = skillService.get(employeeSkill.getSkillId());
        employeeSkill.setEmployee(employee);
        employeeSkill.setSkill(skill);
        return employeeSkillRepository.save(employeeSkill);
    }
}
