package com.kotbihousing.backend.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kotbihousing.backend.dto.ChangePasswordRequest;
import com.kotbihousing.backend.service.PasswordService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class PasswordController {

    private final PasswordService passwordService;

    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(
            Authentication auth,
            @Valid @RequestBody ChangePasswordRequest request) {
        passwordService.changePassword(auth.getName(), request);
        return ResponseEntity.ok(Map.of("message", "Mot de passe modifié avec succès"));
    }
}