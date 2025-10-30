package com.henix_erp.employee_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee_leaves")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class EmployeeLeaves {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "paid_leaves")
    private int paidLeaves;

    @Column(name = "casual_leaves")
    private int casualLeaves;

    @Column(name = "sick_leaves")
    private int sickLeaves;

    @Column(name = "optional_leaves")
    private int optionalLeaves;

    @Column(name = "unpaid_leaves")
    private int unpaidLeaves;

    @Column(name = "remaining_paid_leaves")
    private int remainingPaidLeaves;

    @Column(name = "remaining_casual_leaves")
    private int remainingCasualLeaves;

    @Column(name = "remaining_sick_leaves")
    private int remainingSickLeaves;

    @Column(name = "remaining_optional_leaves")
    private int remainingOptionalLeaves;

    @Transient
    private int employeeId;

    @OneToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnoreProperties({"employeeInformation", "supervisor"})
    private Employee employee;
}
