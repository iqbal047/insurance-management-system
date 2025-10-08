package com.insurance.backend.model;

import com.insurance.backend.enums.DocumentStatus;
import com.insurance.backend.enums.DocumentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer_documents")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CustomerDocument {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Customer customer;

    @Column(nullable = false)
    private DocumentType documentType;

    @Column(nullable = false)
    private String documentUrl;

    @CreationTimestamp
    @Column
    private LocalDateTime uploadedAt;

    @ManyToOne
    @JoinColumn(name = "verified_by", referencedColumnName = "user_id", nullable = true)
    private Employee verifiedBy;

    @Column
    private LocalDateTime verifiedAt;

    @Column(nullable = false)
    private boolean isDeleted = false;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DocumentStatus status = DocumentStatus.PENDING;

    @Column
    private String rejectionReason;

}
