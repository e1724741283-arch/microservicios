package com.practica.sv_auth.services;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.practica.sv_auth.repository.credentialRepository;

@Service
public class authServices {

    @Autowired
    private credentialRepository credentialRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    public Map<String, String> login(CredentialRequest dto) {
        return credentialRepository.findByUsername(dto.getUsername())
                .filter(credential -> passwordEncoder.matches(dto.getPassword(), credential.getPassword()))
                .map(credential -> Map.of(
                    
                    "token", "jwt-token-placeholder" + System.currentTimeMillis(),
                    "message", "Login successful"
                ))
                .orElse(Map.of("message", "Invalid username or password"));
    }
}
