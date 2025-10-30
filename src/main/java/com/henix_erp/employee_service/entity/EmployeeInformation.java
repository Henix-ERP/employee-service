package com.henix_erp.employee_service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "employee_information")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class EmployeeInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "designation")
    private String designation;

    @Column(name = "permanent_address")
    private String permanentAddress;

    @Column(name = "current_address")
    private String currentAddress;

    @Column(name = "emergency_contact_number")
    private String emergencyContactNumber;

    @Column(name = "experience")
    private String experience;

    @Column(name = "department")
    private String department;

    @Column(name = "joining_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    private Date joiningDate;
}
