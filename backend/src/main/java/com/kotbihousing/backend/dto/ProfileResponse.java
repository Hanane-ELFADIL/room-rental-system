package com.kotbihousing.backend.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileResponse {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String city;
    private String role;
}