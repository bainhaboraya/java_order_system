package com.order.order_system.controller;

import com.order.order_system.dto.RoleDto;
import com.order.order_system.service.RoleService;
import com.order.order_system.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;
    private final RoleMapper roleMapper;

    @GetMapping("")
    public ResponseEntity<List<RoleDto>> findAll() {
        List<RoleDto> dtos = roleMapper.toDTO(roleService.findAll());
        return ResponseEntity.ok(dtos);
    }
}
