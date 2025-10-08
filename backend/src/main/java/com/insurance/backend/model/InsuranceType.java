package com.insurance.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "insurance_types")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class InsuranceType {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int insuranceTypeId;

    @Column(nullable = false, unique = true)
    private String typeName;

    @OneToMany(mappedBy = "insuranceType", cascade = CascadeType.ALL)
    private List<InsurancePlan> insurancePlans;

    @Column(nullable = false)
    private boolean isDeleted = false;
}
