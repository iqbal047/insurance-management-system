package com.insurance.backend.model;

import com.insurance.backend.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private TransactionType transactionType;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime transactionTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String userRole;

    // Optional links
    @ManyToOne
    @JoinColumn(name = "policy_id")
    private CustomerPolicy customerPolicy;

    @ManyToOne
    @JoinColumn(name = "withdrawal_id")
    private WithdrawalRequest withdrawalRequest;

    @Column(nullable = false)
    private boolean isDeleted = false;

    @Column
    private String paymentReference;
}
