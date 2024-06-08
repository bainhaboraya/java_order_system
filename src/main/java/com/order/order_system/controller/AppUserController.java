package com.order.order_system.controller;

import com.order.order_system.dto.AppUserDto;
import com.order.order_system.service.AppUserService;
import com.order.order_system.mapper.AppUserMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class AppUserController {
    private final AppUserService appUserService;
    private final AppUserMapper appUserMapper;

    @GetMapping("")
    public ResponseEntity<List<AppUserDto>> findAll() {
        List<AppUserDto> dtos = appUserMapper.toDTO(appUserService.findAll());
        return ResponseEntity.ok(dtos);
    }
}
