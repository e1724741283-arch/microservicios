package com.practica.sv_auth.repository;

import com.practica.sv_auth.model.credential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface credentialRepository extends JpaRepository<credential, Long> {
    Optional<credential> findByUsername(String username);
}
