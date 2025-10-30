package com.henix_erp.employee_service.entity;

import com.henix_erp.common.tenant.TenantEntity;
import com.henix_erp.common.tenant.TenantEntityListener;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "skills")
@EntityListeners(TenantEntityListener.class)
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Skill extends TenantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_active")
    private int isActive;

    @Transient
    private int parentId;

    @ManyToOne
    @JoinColumn(name = "parent_skill")
    private Skill parentSkill;
}
