package com.order.order_system.dto;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass

public class BaseDto <ID extends Number>  {
    private ID id;

    private Integer statusCode;
}
