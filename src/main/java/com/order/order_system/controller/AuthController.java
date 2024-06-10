package com.order.order_system.controller;

import com.order.order_system.dto.AppUserDto;
import com.order.order_system.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AppUserService appUserService;
    

    @PostMapping("/login")
public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
    AppUserDto user = appUserService.findByEmail(email);
    if (user == null) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
    }

    if (!user.getPassword().equals(password)) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
    }

    String authToken = generateAuthToken(user);
    return ResponseEntity.ok("Login successful. Auth Token: " + authToken);
}

private String generateAuthToken(AppUserDto user) {
    return "YourAuthToken";
}
}