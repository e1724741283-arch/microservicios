package com.practica.sv_users.model;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name ="users")
public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;
    
}

