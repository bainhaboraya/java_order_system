package com.order.order_system.mapper;

import com.order.order_system.dto.OrderDto;
import com.order.order_system.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface OrderMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "statusCode", target = "statusCode")
    @Mapping(source = "createdDate", target = "createdDate")
    @Mapping(source = "createdUser", target = "createdUser")
    @Mapping(source = "modifiedDate", target = "modifiedDate")
    @Mapping(source = "modifiedUser", target = "modifiedUser")
    OrderDto toDTO(Order order);

    List<OrderDto> toDTO(List<Order> orders);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "statusCode", target = "statusCode")
    @Mapping(source = "createdDate", target = "createdDate")
    @Mapping(source = "createdUser", target = "createdUser")
    @Mapping(source = "modifiedDate", target = "modifiedDate")
    @Mapping(source = "modifiedUser", target = "modifiedUser")
    Order toEntity(OrderDto orderDto);
}
