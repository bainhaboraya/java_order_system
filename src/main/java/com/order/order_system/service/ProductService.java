package com.order.order_system.service;

import com.order.order_system.entity.Product;
import com.order.order_system.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends BaseService<Product, Long> {

    @Autowired
    private ProductRepo productRepo;

    public void insert(Product product) {
        productRepo.save(product);
    }

    public List<Product> findAll() {
        return productRepo.findAll();
    }
    public void updateStatus(Long id, Integer statusCode) {
        productRepo.updateStatus(statusCode, id);
    }
}
