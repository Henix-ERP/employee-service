package com.henix_erp.employee_service.service;


import com.henix_erp.employee_service.entity.EmployeeLeaves;

public interface EmployeeLeavesService {

    public EmployeeLeaves create(EmployeeLeaves employeeLeaves);

    public EmployeeLeaves get(int id);

    public EmployeeLeaves getEmployeeLeaves(int id);
}