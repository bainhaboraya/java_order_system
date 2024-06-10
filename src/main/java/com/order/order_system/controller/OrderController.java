package com.order.order_system.controller;

import com.order.order_system.dto.OrderDto;
import com.order.order_system.entity.Order;
import com.order.order_system.service.OrderService;
import com.order.order_system.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping("")
    public ResponseEntity<List<OrderDto>> findAll() {
        List<OrderDto> dtos = orderMapper.toDTO(orderService.findAll());
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("")
    public ResponseEntity<OrderDto> create(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        orderService.insert(order);
        
        startFulfillment(order);
        return ResponseEntity.ok(orderMapper.toDTO(order));
    }

    private void startFulfillment(Order order) {
        
    }
}
