package com.practica.sv_users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class usersRequest {

    @NotBlank(message = "El Nombre es requerido")
    private String name;

    @NotBlank(message = "El Usuario es requerido")
    private String username;

    @Email(message = "El formato del correo electrónico es inválido")
    @NotBlank(message = "El Correo Electrónico es requerido")
    private String email;
}
