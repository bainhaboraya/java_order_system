package com.order.order_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseEntity<Long> {
   
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int quantity;

    @Column(name = "status_code")
    private Integer statusCode;

    public Product() {}

    public Product(String name, double price, int quantity) {
        if(price <= 0) throw new IllegalArgumentException("Price must be greater than 0");
        if(quantity < 1) throw new IllegalArgumentException("Quantity must be 1 or more");
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
