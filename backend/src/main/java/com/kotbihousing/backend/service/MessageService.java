package com.kotbihousing.backend.service;

import com.kotbihousing.backend.model.Message;
import com.kotbihousing.backend.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final NotificationService notificationService;

    public Message send(Message message) {
        Message saved = messageRepository.save(message);
        notificationService.create(
                message.getReceiverId(),
                "Vous avez reçu un nouveau message"
        );
        return saved;
    }

    public List<Message> getByBookingId(Long bookingId) {
        return messageRepository.findByRentalRequestIdOrderByCreatedAtAsc(bookingId);
    }

    public void markAsRead(Long id) {
        messageRepository.findById(id).ifPresent(m -> {
            m.setRead(true);
            messageRepository.save(m);
        });
    }

    public long countUnread(Long userId) {
        return messageRepository.findByReceiverIdAndIsReadFalse(userId).size();
    }
}