package com.kotbihousing.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageCreateDTO {
    private Long senderId;
    private Long receiverId;
    private Long rentalRequestId;
    private String content;
}
