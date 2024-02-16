package com.poc.msjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.msjwt.service.JwtTokenService;

@RestController
public class JwtController {
    @Autowired
    private JwtTokenService jwtTokenService;

    @GetMapping("/token")
    public ResponseEntity<String> generateToken(@RequestParam String username) {
        String token = jwtTokenService.generateToken(username);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Welcome to ms-jwt");
    }
}
