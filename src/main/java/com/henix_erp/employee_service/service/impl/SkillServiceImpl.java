package com.henix_erp.employee_service.service.impl;

import com.henix_erp.employee_service.entity.Skill;
import com.henix_erp.employee_service.repository.SkillRepository;
import com.henix_erp.employee_service.service.SkillService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {

    SkillRepository skillRepository;

    SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public Skill create(Skill skill) {
        Skill parentSkill = get(skill.getParentId());
        if(parentSkill != null) {
            skill.setParentSkill(parentSkill);
        }
        return skillRepository.save(skill);
    }

    @Override
    public Skill get(int id) {
        Optional<Skill> optional = skillRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Skill> getAll() {
        return skillRepository.findAll();
    }
}
