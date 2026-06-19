package com.practica.sv_orders.controller;
import com.practica.sv_orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RequestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Map<String, Object> createOrder(@Valid @RequestBody ordersRequest dto){
        return orderService.createOrder(dto);
    }
    @GetMapping("/{id}")
    public Map<String, Object> getOrder(@PathVariable String id){
        return orderService.getOrders(id);
    }

    @GetMapping("/health")
    public Map<String, Object> health(){
        return Map.of("status", "orders service is healthy");
    }
}