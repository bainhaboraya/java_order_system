package com.order.order_system.controller;

import com.order.order_system.dto.ProductDto;
import com.order.order_system.entity.Product;
import com.order.order_system.service.ProductService;
import com.order.order_system.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping("")
    public ResponseEntity<List<ProductDto>> findAll() {
        List<ProductDto> dtos = productMapper.toDTO(productService.findAll());
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("")
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        productService.insert(product);
        return ResponseEntity.ok(productMapper.toDTO(product));
    }
}
