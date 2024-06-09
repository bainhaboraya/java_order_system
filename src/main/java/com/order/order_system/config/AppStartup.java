package com.order.order_system.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.order.order_system.entity.AppUser;
import com.order.order_system.entity.Order;
import com.order.order_system.entity.Product;
import com.order.order_system.entity.Role;
import com.order.order_system.service.AppUserService;
import com.order.order_system.service.OrderService;
import com.order.order_system.service.ProductService;
import com.order.order_system.service.RoleService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AppStartup implements CommandLineRunner {
    private final AppUserService userService;
    private final RoleService roleService;
    private final ProductService productService;
    private final OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        addRoleDemoData();
        addUserDemoData();
        addProductDemoData();
        addOrderDemoData();
    }

    public void addUserDemoData() {
        if (userService.findAll().isEmpty()) {
            userService.insert(new AppUser("Bainh", "Alaa", "mali", "123", Arrays.asList(roleService.findByName("Admin"))));
            userService.insert(new AppUser("Esraa", "Alaa", "mali", "123", Arrays.asList(roleService.findByName("User"))));
        }
    }

    public void addRoleDemoData() {
        if (roleService.findAll().isEmpty()) {
            roleService.insert(new Role("Admin"));
            roleService.insert(new Role("User"));
        }
    }

    public void addProductDemoData() {
        if (productService.findAll().isEmpty()) {
            productService.insert(new Product("Product1", 100.0, 10));
            productService.insert(new Product("Product2", 50.0, 5));
        }
    }

    public void addOrderDemoData() {
        if (orderService.findAll().isEmpty()) {
            Product product1 = productService.findAll().get(0);
            Product product2 = productService.findAll().get(1);
            Order order = new Order();
            order.setProducts(Arrays.asList(product1, product2));
            orderService.insert(order);
        }
    }
}
