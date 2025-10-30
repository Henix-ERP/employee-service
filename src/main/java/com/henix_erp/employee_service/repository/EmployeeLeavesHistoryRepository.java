package com.henix_erp.employee_service.repository;

import com.henix_erp.employee_service.entity.EmployeeLeavesHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeLeavesHistoryRepository extends JpaRepository<EmployeeLeavesHistory, Integer> {

    @Query("SELECT elh FROM EmployeeLeavesHistory elh WHERE elh.employee.id = :employeeId")
    Optional<List<EmployeeLeavesHistory>> findByEmployeeId(int employeeId);
}
