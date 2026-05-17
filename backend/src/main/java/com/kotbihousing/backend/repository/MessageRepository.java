package com.kotbihousing.backend.repository;

import com.kotbihousing.backend.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByRentalRequestIdOrderByCreatedAtAsc(Long rentalRequestId);
    List<Message> findByReceiverIdAndIsReadFalse(Long receiverId);
}