package com.order.order_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.order_system.entity.Role;
import com.order.order_system.repository.RoleRepo;

@Service
public class RoleService extends BaseService<Role,Long> {

    @Autowired
    private RoleRepo roleRepo;

    public void insert(Role role) {
        roleRepo.save(role);
    }

    public List<Role> findAll() {
        return roleRepo.findAll();
    }
    public Role findByName(String name) {
        return roleRepo.findByName(name);
    }
}
