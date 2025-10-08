package com.insurance.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "agents")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Agent extends User{

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    @Column(nullable = false)
    private boolean isApproved = false;

    @ManyToOne
    @JoinColumn(name = "approved_by", referencedColumnName = "user_id", nullable = true)
    private Employee approvedBy;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalEarnings = BigDecimal.ZERO;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CustomerPolicy> soldPolicies;
}
