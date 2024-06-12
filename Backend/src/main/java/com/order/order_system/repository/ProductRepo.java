package com.order.order_system.repository;

import com.order.order_system.entity.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepo extends BaseRepository<Product, Long> {

    @Transactional
    @Modifying
    @Query("update Product p set p.statusCode = :statusCode where p.id = :id")
    void updateStatus(@Param("statusCode") Integer statusCode, @Param("id") Long id);
}
