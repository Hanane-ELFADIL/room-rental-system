package com.kotbihousing.backend.controller;

import com.kotbihousing.backend.model.Room;
import com.kotbihousing.backend.model.User;
import com.kotbihousing.backend.service.RoomService;
import com.kotbihousing.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:5173")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

    // GET toutes les chambres — PUBLIC
    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    // GET chambres de l'owner connecté — AUTH REQUIRED
    @GetMapping("/my-rooms")
    public ResponseEntity<?> getMyRooms(Authentication authentication) {
        if (authentication == null) {
            return ResponseEntity.status(401).body("Non authentifié");
        }

        String email = authentication.getName();
        User owner = userService.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found: " + email));

        // Vérifier que c'est un OWNER
        if (owner.getRole() != User.Role.OWNER) {
            return ResponseEntity.status(403).body("Accès refusé");
        }

        return ResponseEntity.ok(roomService.getRoomsByOwnerId(owner.getId()));
    }

    // GET un room par ID — PUBLIC
    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST créer un room — OWNER ONLY
    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody Room room, Authentication authentication) {
        if (authentication == null) {
            return ResponseEntity.status(401).body("Non authentifié");
        }

        String email = authentication.getName();
        User owner = userService.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found: " + email));

        room.setOwnerId(owner.getId());
        room.setOwnerName(owner.getFullName());

        Room created = roomService.createRoom(room);
        return ResponseEntity.ok(created);
    }

    // PUT modifier un room — OWNER ONLY
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRoom(@PathVariable Long id,
                                        @RequestBody Room room,
                                        Authentication authentication) {
        if (authentication == null) {
            return ResponseEntity.status(401).body("Non authentifié");
        }

        String email = authentication.getName();
        User currentUser = userService.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found: " + email));

        Room existing = roomService.getRoomById(id)
                .orElseThrow(() -> new RuntimeException("Room not found: " + id));

        System.out.println("==> PUT /rooms/" + id
            + " | existing.ownerId=" + existing.getOwnerId()
            + " | currentUser.id=" + currentUser.getId()
            + " | currentUser.email=" + currentUser.getEmail());

        if (!existing.getOwnerId().equals(currentUser.getId())
                && currentUser.getRole() != User.Role.ADMIN) {
            return ResponseEntity.status(403).body("Vous n'êtes pas le propriétaire de cette chambre");
        }

        // Préserver ownerId et ownerName de la chambre existante
        room.setOwnerId(existing.getOwnerId());
        room.setOwnerName(existing.getOwnerName());

        return ResponseEntity.ok(roomService.updateRoom(id, room));
    }

    // DELETE supprimer un room — OWNER ONLY
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable Long id, Authentication authentication) {
        if (authentication == null) {
            return ResponseEntity.status(401).body("Non authentifié");
        }

        String email = authentication.getName();
        User currentUser = userService.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found: " + email));

        Room existing = roomService.getRoomById(id)
                .orElseThrow(() -> new RuntimeException("Room not found: " + id));

        if (!existing.getOwnerId().equals(currentUser.getId())
                && currentUser.getRole() != User.Role.ADMIN) {
            return ResponseEntity.status(403).body("Vous n'êtes pas le propriétaire de cette chambre");
        }

        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}