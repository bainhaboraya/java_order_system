package com.order.order_system.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseDto<T> {
    private T id;
    private LocalDateTime createdDate;
    private String createdUser;
    private LocalDateTime modifiedDate;
    private String modifiedUser;
}
