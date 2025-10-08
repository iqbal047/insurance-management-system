package com.insurance.backend.model;

import com.insurance.backend.enums.WithdrawalStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "policy_claims")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyClaim {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_policy_id", nullable = false)
    private CustomerPolicy customerPolicy;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WithdrawalStatus status = WithdrawalStatus.PENDING;

    @Column(nullable = false)
    private String reason;

    private String remarks; // Optional

    @Column(nullable = false)
    private boolean isEarlyClaim;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal penaltyAmount;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal claimAmount;

    @ManyToOne
    @JoinColumn(name = "verified_by")
    private Employee verifiedBy;

    @CreationTimestamp
    private LocalDateTime requestedAt;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @Column(nullable = false)
    private boolean isDeleted = false;
}
