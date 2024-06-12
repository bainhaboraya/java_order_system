package com.order.order_system.controller;

import com.order.order_system.dto.AppUserDto;
import com.order.order_system.service.AppUserService;
<<<<<<< HEAD
import com.order.order_system.dto.LoginRequestDto; 
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

@CrossOrigin(origins = "http://localhost:4200")
=======
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

>>>>>>> 1fc5efe02db8e1d7a9a47eb2340af15245c05eec
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AppUserService appUserService;
<<<<<<< HEAD

   
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequest) {
        AppUserDto user = appUserService.findByEmail(loginRequest.getEmail());
        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }

        String authToken = generateAuthToken(user);
        return ResponseEntity.ok("Login successful. Auth Token: " + authToken);
    }

    private String generateAuthToken(AppUserDto user) {
        return Jwts.builder()
                .claim("userId", user.getId()) 
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }
}
=======
    

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
>>>>>>> 1fc5efe02db8e1d7a9a47eb2340af15245c05eec
