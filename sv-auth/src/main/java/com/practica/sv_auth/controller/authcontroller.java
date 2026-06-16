package com.practica.sv_auth.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.practica.sv_auth.dto.credentialRequest;
import com.practica.sv_auth.services.authServices;

import jakarta.validation.Valid;


@RestController
public class authcontroller {

    @Autowired
    private authServices authServices;  

    @PostMapping("/login")
    public Map<String, String> login(@Valid @RequestBody credentialRequest dto) {
        return authServices.login(dto);
    }


    @GetExchange("/health")
    public Map<String, String> health() {
        return Map.of("services", "svc-auth", "status", "ok");
    }
}
