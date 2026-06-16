package com.practica.sv_orders.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
    
@Data
public class ordersRequest {
    @NotBlank(message = "El Detalle es requerido")
    private String detail;

    @NotBlank(message = "El Usuario es requerido")
    private long userId;
}
