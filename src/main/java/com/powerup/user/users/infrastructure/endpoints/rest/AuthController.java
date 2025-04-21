package com.powerup.user.users.infrastructure.endpoints.rest;

import com.powerup.user.users.application.dto.request.LoginUserRequest;
import com.powerup.user.users.application.dto.response.LoginResponse;
import com.powerup.user.users.application.services.AuthService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserRequest request) {
        LoginResponse response = authService.loginUser(request);
        return ResponseEntity.ok(response);
    }
}
