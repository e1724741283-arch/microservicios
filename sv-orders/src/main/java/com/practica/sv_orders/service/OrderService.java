package com.practica.sv_orders.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practica.sv_orders.dto.ordersRequest;
import com.practica.sv_orders.model.orders;
import com.practica.sv_orders.repository.ordersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class OrderService {
    @Autowired
    private ordersRepository orderRepository;

    @Autowired
    private StringRedisTemplate redis;

    @Autowired
    private ObjectMapper objectMapper;

    public Map<String, Object> createOrder(ordersRequest dto){
        String id = "PED"+ UUID.randomUUID().toString();
        orders order = new orders();
        order.setId(id);
        order.setDate(new Date().toString());
        order.setDetail(dto.getDetail());
        order.setUserId(dto.getUserId());
        orderRepository.save(order);

        redis.delete("order:all");
        return Map.of("Mensaje", "Pedido creado con exito", "id", id);

    }

    public Map<String, Object> getOrders(String id){
        String cacheKey = "order:" + id;
        String cachedOrder = redis.opsForValue().get(cacheKey);
        if (cachedOrder != null) {
            try {
                Map<String, Object> orderCache = objectMapper.readValue(
                    cachedOrder, new TypeReference<Map<String, Object>>() {});
                    return Map.of("fuente", "Cache Redis (2ms)", "datos", orderCache);
            } catch (Exception e) {
                System.out.println(e.toString());
                redis.delete(cacheKey);
            }
        }

        Optional<orders> orderOpt = orderRepository.findById(id);
        if (orderOpt.isEmpty()) {
            return Map.of("Mensaje", "Pedido no encontrado");
        }
        orders order = orderOpt.get();
        try {
            String orderJson = objectMapper.writeValueAsString(order);
            redis.opsForValue().set(cacheKey, orderJson, 60, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return Map.of("fuente", "Base de datos (50ms)", "datos", order);
    }
}
