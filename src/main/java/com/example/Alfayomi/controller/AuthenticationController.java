package com.example.Alfayomi.controller;

import com.example.Alfayomi.dto.AuthenticationResponse;
import com.example.Alfayomi.dto.LoginDTO;
import com.example.Alfayomi.dto.RegisterDTO;
import com.example.Alfayomi.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterDTO registerDTO
            ){
        return ResponseEntity.ok(authenticationService.register(registerDTO));
    }
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody LoginDTO login
            ){
        return ResponseEntity.ok(authenticationService.authenticate(login));
    }
}
