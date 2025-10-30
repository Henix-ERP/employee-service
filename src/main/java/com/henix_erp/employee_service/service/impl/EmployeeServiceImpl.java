package com.henix_erp.employee_service.service.impl;

import com.henix_erp.employee_service.entity.Employee;
import com.henix_erp.employee_service.entity.EmployeeLeaves;
import com.henix_erp.employee_service.repository.EmployeeRepository;
import com.henix_erp.employee_service.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(Employee employee) {
        if(employee.getSupervisorId() != null) {
            Employee supervisor = get(employee.getSupervisorId());
            employee.setSupervisor(supervisor);
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee get(int id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
