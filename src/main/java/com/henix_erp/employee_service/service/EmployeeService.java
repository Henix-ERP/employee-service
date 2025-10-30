package com.henix_erp.employee_service.service;

import com.henix_erp.employee_service.entity.Employee;
import com.henix_erp.employee_service.entity.EmployeeLeaves;

import java.util.List;

public interface EmployeeService {

    public Employee create(Employee employee);

    public Employee get(int id);

    public List<Employee> getAll();
}
