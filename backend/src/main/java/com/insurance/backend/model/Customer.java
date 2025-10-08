package com.insurance.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer extends User{

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private List<CustomerPolicy> customerPolicies;

    @ManyToOne
    @JoinColumn(name = "registered_by")
    private Agent registeredBy;

}
