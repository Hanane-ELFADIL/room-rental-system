package com.kotbihousing.backend.service;

import org.springframework.stereotype.Service;

import com.kotbihousing.backend.dto.ProfileResponse;
import com.kotbihousing.backend.dto.UpdateProfileRequest;
import com.kotbihousing.backend.entity.User;
import com.kotbihousing.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ProfileResponse getProfile(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        return new ProfileResponse(
                user.getId(), user.getFullName(), user.getEmail(),
                user.getPhone(), user.getCity(), user.getRole().name()
        );
    }

    public ProfileResponse updateProfile(String email, UpdateProfileRequest request) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        if (request.getFullName() != null) user.setFullName(request.getFullName());
        if (request.getPhone() != null) user.setPhone(request.getPhone());
        if (request.getCity() != null) user.setCity(request.getCity());

        userRepository.save(user);
        return new ProfileResponse(
                user.getId(), user.getFullName(), user.getEmail(),
                user.getPhone(), user.getCity(), user.getRole().name()
        );
    }
}