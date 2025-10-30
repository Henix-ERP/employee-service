package com.henix_erp.employee_service.controller;

import com.henix_erp.employee_service.entity.Skill;
import com.henix_erp.employee_service.service.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class SkillController {

    SkillService skillService;

    SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping("/skill")
    public ResponseEntity<Skill> create(@RequestBody Skill skill) {
        Skill savedSkill = skillService.create(skill);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSkill);
    }

    @GetMapping("/skill/{id}")
    public ResponseEntity<Skill> get(@PathVariable int id) {
        Skill skill = skillService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(skill);
    }

    @GetMapping("/skills")
    public ResponseEntity<List<Skill>> getAll() {
        List<Skill> skills = skillService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(skills);
    }
}
