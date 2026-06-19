package com.practica.sv_orders.service;

import com.practica.sv_orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;



@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private StringRedisTemplate redis;

    @Autowired
    private ObjectMapper objectMapper;

    public Map<String, Object> createOrder(OrderRequest dto){
        String id = "PED"+ UUID.randomUUID().toString();
        Order order = new Order();
        order.setId(id);
        order.setDate(new Date().toString());
     
    }
}