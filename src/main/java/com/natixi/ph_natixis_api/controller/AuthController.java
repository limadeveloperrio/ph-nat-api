package com.natixi.ph_natixis_api.controller;

import com.natixi.ph_natixis_api.conf.JwtUtil;
import com.natixi.ph_natixis_api.model.AppUserProperties;
import com.natixi.ph_natixis_api.model.AuthResponse;
import com.natixi.ph_natixis_api.model.LoginRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AppUserProperties appUser;

    public AuthController(AppUserProperties appUser) {
        this.appUser = appUser;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest request) {
        if (appUser.name().equals(request.username()) &&
                appUser.password().equals(request.password())) {

            List<String> authorities = List.of("ROLE_ADMIN", "ROLE_USER");
            String token = JwtUtil.generateToken(request.username(), authorities);

            return ResponseEntity.ok(new AuthResponse(token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/me")
    public String me(Authentication authentication) {
        return "Usuário logado: " + authentication.getName();
    }
}
