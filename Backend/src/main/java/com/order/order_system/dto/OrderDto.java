package com.order.order_system.dto;

import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
public class OrderDto extends BaseDto<Long> {
    private Long id;
    private String statusCode;
    private List<ProductDto> products;
}
