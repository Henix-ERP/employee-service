package com.henix_erp.employee_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "employees")
@NoArgsConstructor @AllArgsConstructor @Setter @Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "user_id")
    private int userId;

    @Transient
    private Integer supervisorId;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    @JsonIgnoreProperties({"employeeInformation", "skills", "supervisor"})
    private Employee supervisor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_information_id")
    private EmployeeInformation employeeInformation;
}
