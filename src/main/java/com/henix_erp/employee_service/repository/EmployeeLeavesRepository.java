package com.henix_erp.employee_service.repository;

import com.henix_erp.employee_service.entity.EmployeeLeaves;
import com.henix_erp.employee_service.entity.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeLeavesRepository extends JpaRepository<EmployeeLeaves, Integer> {

    @Query("SELECT el FROM EmployeeLeaves el WHERE el.employee.id = :employeeId")
    Optional<EmployeeLeaves> findByEmployeeId(int employeeId);
}
