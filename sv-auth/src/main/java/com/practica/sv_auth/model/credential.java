package com.practica.sv_auth.model;
import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name ="credentials")
public class credential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String rol;
}

