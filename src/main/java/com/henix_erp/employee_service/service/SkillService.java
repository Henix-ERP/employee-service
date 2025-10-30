package com.henix_erp.employee_service.service;

import com.henix_erp.employee_service.entity.EmployeeSkill;
import com.henix_erp.employee_service.entity.Skill;

import java.util.List;

public interface SkillService {

    public Skill create(Skill skill);

    public Skill get(int id);

    public List<Skill> getAll();
}
