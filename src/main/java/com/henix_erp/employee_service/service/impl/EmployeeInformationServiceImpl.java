package com.henix_erp.employee_service.service.impl;

import com.henix_erp.employee_service.entity.EmployeeInformation;
import com.henix_erp.employee_service.repository.EmployeeInformationRepository;
import com.henix_erp.employee_service.service.EmployeeInformationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeInformationServiceImpl implements EmployeeInformationService {

    EmployeeInformationRepository employeeInformationRepository;

    EmployeeInformationServiceImpl(EmployeeInformationRepository employeeInformationRepository) {
        this.employeeInformationRepository = employeeInformationRepository;
    }
    @Override
    public EmployeeInformation create(EmployeeInformation employeeInformation) {
        return employeeInformationRepository.save(employeeInformation);
    }

    @Override
    public EmployeeInformation get(int id) {
        Optional<EmployeeInformation> optional = employeeInformationRepository.findById(id);
        return optional.orElse(null);
    }
}
