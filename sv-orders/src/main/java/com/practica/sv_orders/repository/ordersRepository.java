package com.practica.sv_orders.repository;

import com.practica.sv_orders.model.orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ordersRepository extends JpaRepository<orders, String> {
}
