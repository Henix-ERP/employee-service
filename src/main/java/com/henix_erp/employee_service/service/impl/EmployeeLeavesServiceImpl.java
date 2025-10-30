package com.henix_erp.employee_service.service.impl;

import com.henix_erp.employee_service.entity.Employee;
import com.henix_erp.employee_service.entity.EmployeeLeaves;
import com.henix_erp.employee_service.repository.EmployeeLeavesRepository;
import com.henix_erp.employee_service.service.EmployeeLeavesService;
import com.henix_erp.employee_service.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeLeavesServiceImpl implements EmployeeLeavesService {

    EmployeeLeavesRepository employeeLeavesRepository;
    EmployeeService employeeService;

    EmployeeLeavesServiceImpl(
            EmployeeLeavesRepository employeeLeavesRepository,
            EmployeeService employeeService
    ) {
        this.employeeLeavesRepository = employeeLeavesRepository;
        this.employeeService = employeeService;
    }

    @Override
    public EmployeeLeaves create(EmployeeLeaves employeeLeaves) {
        Employee employee = employeeService.get(employeeLeaves.getEmployeeId());
        employeeLeaves.setEmployee(employee);
        return employeeLeavesRepository.save(employeeLeaves);
    }

    @Override
    public EmployeeLeaves get(int id) {
        Optional<EmployeeLeaves> optional = employeeLeavesRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public EmployeeLeaves getEmployeeLeaves(int id) {
        Optional<EmployeeLeaves> employeeLeaves = employeeLeavesRepository.findByEmployeeId(id);
        return employeeLeaves.orElse(null);
    }
}
