package com.kotbihousing.backend.controller;

import com.kotbihousing.backend.dto.RentalRequestDTO;
import com.kotbihousing.backend.dto.RentalRequestResponse;
import com.kotbihousing.backend.model.RentalRequest.RequestStatus;
import com.kotbihousing.backend.model.User;
import com.kotbihousing.backend.repository.UserRepository;
import com.kotbihousing.backend.service.RentalRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class RentalRequestController {

    private final RentalRequestService requestService;
    private final UserRepository userRepository;

    private User getCurrentUser(Authentication authentication) {
        if (authentication == null) return null;
        String email = authentication.getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé: " + email));
    }

    @PostMapping
    public ResponseEntity<?> createRequest(
            @RequestBody RentalRequestDTO dto,
            Authentication authentication) {
        User currentUser = getCurrentUser(authentication);
        if (currentUser == null) return ResponseEntity.status(401).body("Non authentifié");
        return ResponseEntity.ok(requestService.createRequest(dto, currentUser.getId()));
    }

    @GetMapping("/owner")
    public ResponseEntity<?> getOwnerRequests(Authentication authentication) {
        User currentUser = getCurrentUser(authentication);
        if (currentUser == null) return ResponseEntity.status(401).body("Non authentifié");
        return ResponseEntity.ok(requestService.getRequestsForOwner(currentUser.getId()));
    }

    @GetMapping("/student")
    public ResponseEntity<?> getStudentRequests(Authentication authentication) {
        User currentUser = getCurrentUser(authentication);
        if (currentUser == null) return ResponseEntity.status(401).body("Non authentifié");
        return ResponseEntity.ok(requestService.getRequestsByStudent(currentUser.getId()));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<RentalRequestResponse> updateStatus(
            @PathVariable Long id,
            @RequestParam RequestStatus status) {
        return ResponseEntity.ok(requestService.updateStatus(id, status));
    }
}