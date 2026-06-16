package com.practica.sv_orders.model;
import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name ="orders")
public class orders {

    @Id
    private String id;

    private String status;
    private String date;
    private String detail;
    private long userId;
    
}
