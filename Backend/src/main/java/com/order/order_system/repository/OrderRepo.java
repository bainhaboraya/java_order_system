package com.order.order_system.repository;

import com.order.order_system.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends BaseRepository<Order, Long> {
}
