package com.henix_erp.employee_service.service.impl;

import com.henix_erp.employee_service.entity.Employee;
import com.henix_erp.employee_service.entity.EmployeeLeavesHistory;
import com.henix_erp.employee_service.repository.EmployeeLeavesHistoryRepository;
import com.henix_erp.employee_service.service.EmployeeLeavesHistoryService;
import com.henix_erp.employee_service.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeLeavesHistoryServiceImpl implements EmployeeLeavesHistoryService {

    EmployeeLeavesHistoryRepository employeeLeavesHistoryRepository;
    EmployeeService employeeService;

    EmployeeLeavesHistoryServiceImpl(
            EmployeeLeavesHistoryRepository employeeLeavesHistoryRepository,
            EmployeeService employeeService
    ) {
        this.employeeLeavesHistoryRepository = employeeLeavesHistoryRepository;
        this.employeeService = employeeService;
    }

    @Override
    public EmployeeLeavesHistory create(EmployeeLeavesHistory employeeLeavesHistory) {
        Employee employee = employeeService.get(employeeLeavesHistory.getEmployeeId());
        employeeLeavesHistory.setEmployee(employee);
        return employeeLeavesHistoryRepository.save(employeeLeavesHistory);
    }

    @Override
    public List<EmployeeLeavesHistory> getEmployeeLeavesHistory(int id) {
        Optional<List<EmployeeLeavesHistory>> leavesHistories = employeeLeavesHistoryRepository.findByEmployeeId(id);
        return leavesHistories.orElse(null);
    }
}
