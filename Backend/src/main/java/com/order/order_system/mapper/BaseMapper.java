package com.order.order_system.mapper;

public interface BaseMapper<T,DTO> {
    DTO map(T entity);
    T unmap(DTO dto);
    
} 
