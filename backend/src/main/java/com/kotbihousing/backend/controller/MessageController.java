package com.kotbihousing.backend.controller;

import com.kotbihousing.backend.dto.MessageCreateDTO;
import com.kotbihousing.backend.model.Message;
import com.kotbihousing.backend.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<Message> sendMessage(@RequestBody MessageCreateDTO dto) {
        Message message = new Message();
        message.setSenderId(dto.getSenderId());
        message.setReceiverId(dto.getReceiverId());
        message.setRentalRequestId(dto.getRentalRequestId());
        message.setContent(dto.getContent());
        return ResponseEntity.ok(messageService.send(message));
    }

    @GetMapping("/rental-request/{rentalRequestId}")
    public ResponseEntity<List<Message>> getMessagesByRentalRequest(@PathVariable Long rentalRequestId) {
        return ResponseEntity.ok(messageService.getByBookingId(rentalRequestId));
    }

    @PutMapping("/{id}/read")
    public ResponseEntity<Void> markAsRead(@PathVariable Long id) {
        messageService.markAsRead(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/unread/count")
    public ResponseEntity<Long> getUnreadCount(@RequestParam Long userId) {
        return ResponseEntity.ok(messageService.countUnread(userId));
    }
}
