package com.insurance.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name= "password_reset_token")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class PasswordResetToken
{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pass_id;

    @Column
    private String token;

    @OneToOne
    @JoinColumn(name="user_id",nullable=false)
    private User user;

    @Column
    private LocalDateTime expiryDate;

}
