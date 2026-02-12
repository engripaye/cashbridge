package dev.engripaye.cashbridgebackend.controller;


import dev.engripaye.cashbridgebackend.dto.AuthResponse;
import dev.engripaye.cashbridgebackend.dto.LoginRequest;
import dev.engripaye.cashbridgebackend.dto.RegisterRequest;
import dev.engripaye.cashbridgebackend.security.JwtUtil;
import dev.engripaye.cashbridgebackend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        AuthResponse response = authService.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@ResponseBody LoginRequest request){

    }



}
