package com.insurance.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "states")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class State {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stateId;

    @Column
    @NotBlank(message = "State name can not be empty")
    private String stateName;

    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<City> cities;

    @Column(nullable = false)
    private boolean isDeleted = false;
}
