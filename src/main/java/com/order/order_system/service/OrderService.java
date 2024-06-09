package com.order.order_system.service;

import com.order.order_system.entity.Order;
import com.order.order_system.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService extends BaseService<Order, Long> {

    @Autowired
    private OrderRepo orderRepo;

    public void insert(Order order) {
        orderRepo.save(order);
    }

    public List<Order> findAll() {
        return orderRepo.findAll();
    }
}
