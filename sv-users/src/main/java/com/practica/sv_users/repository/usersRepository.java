package com.practica.sv_users.repository;

import com.practica.sv_users.model.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface usersRepository extends JpaRepository<users, Long> {
    Optional<users> findByUsername(String username);
}