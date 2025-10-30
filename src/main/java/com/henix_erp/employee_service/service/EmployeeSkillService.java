package com.henix_erp.employee_service.service;

import com.henix_erp.employee_service.entity.EmployeeSkill;

import java.util.List;

public interface EmployeeSkillService {

    public EmployeeSkill create(EmployeeSkill employeeSkill);

    public List<EmployeeSkill> getEmployeeSkills(int id);
}
