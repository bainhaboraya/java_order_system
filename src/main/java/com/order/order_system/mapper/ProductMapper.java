package com.order.order_system.mapper;

import com.order.order_system.dto.ProductDto;
import com.order.order_system.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDTO(Product product);

    List<ProductDto> toDTO(List<Product> products);

    Product toEntity(ProductDto productDto);
}
