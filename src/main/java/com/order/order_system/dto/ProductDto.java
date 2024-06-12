package com.order.order_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto extends BaseDto<Long> {
    private String name;
    private double price;
    private int quantity;
    private Integer statusCode;
}
