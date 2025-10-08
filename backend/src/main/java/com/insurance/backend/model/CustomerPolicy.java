package com.insurance.backend.model;

import com.insurance.backend.enums.PaymentFrequency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "customer_policies")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class CustomerPolicy {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Customer customer;

    @ManyToOne()
    @JoinColumn(name = "insurance_plan_id")
    private InsurancePlan insurancePlan;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentFrequency paymentFrequency;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal calculatedPremium;

    @Column(nullable = false)
    private BigDecimal selectedCoverageAmount;

    @Column(nullable = false)
    private int selectedDurationYears;

    // dates null before activation
    @Column(nullable = true)
    private LocalDate startDate;

    @Column(nullable = true)
    private LocalDate endDate;

    @Column(nullable = true)
    private LocalDate nextDueDate;

    @Column(nullable = false)
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "approved_by", referencedColumnName = "user_id", nullable = true)
    private Employee approvedBy;

    @ManyToOne
    @JoinColumn(name = "agent_id", referencedColumnName = "user_id", nullable = true)
    private Agent agent;

    @Column(nullable = false)
    private boolean isCancelled = false;

    private LocalDate cancellationDate;

    @Column(name = "is_rejected")
    private boolean isRejected = false;

    @Column(name = "rejection_reason")
    private String rejectionReason;
}
