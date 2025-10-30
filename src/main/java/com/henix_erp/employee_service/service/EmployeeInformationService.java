package com.henix_erp.employee_service.service;

import com.henix_erp.employee_service.entity.EmployeeInformation;

public interface EmployeeInformationService {

    public EmployeeInformation create(EmployeeInformation employeeInformation);

    public EmployeeInformation get(int id);
}
