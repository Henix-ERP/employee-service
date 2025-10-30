package com.henix_erp.employee_service.service;

import com.henix_erp.employee_service.entity.EmployeeLeavesHistory;

import java.util.List;

public interface EmployeeLeavesHistoryService {

    public EmployeeLeavesHistory create(EmployeeLeavesHistory employeeLeavesHistory);

    public List<EmployeeLeavesHistory> getEmployeeLeavesHistory(int id);
}
