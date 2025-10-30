package com.henix_erp.employee_service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "employee_leaves_history")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class EmployeeLeavesHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "start_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startDate;

    @Column(name = "end_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date endDate;

    @Column(name = "total_leave")
    private int totalLeave;

    @Column(name = "type")
    private String type;

    @Column(name = "subject")
    private String subject;

    @Column(name = "note")
    private String note;

    @Column(name = "approval_status")
    private String approvalStatus;

    @Transient
    private int employeeId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnoreProperties({"employeeInformation", "supervisor"})
    private Employee employee;
}
