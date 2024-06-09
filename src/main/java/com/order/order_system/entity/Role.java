package com.order.order_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "security_roles")
public class Role extends BaseEntity<Long> {
    private String name;
    private Integer statusCode;

    public Role() {}

    public Role(String name) {
        this.name = name;
    }
    
}
