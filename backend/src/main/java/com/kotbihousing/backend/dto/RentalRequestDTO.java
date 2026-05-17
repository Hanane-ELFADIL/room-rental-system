package com.kotbihousing.backend.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class RentalRequestDTO {
    private Long roomId;
    private String studentName;
    private String studentEmail;
    private String studentPhone;
    private LocalDate moveInDate;
    private String duration;
    private String message;
}