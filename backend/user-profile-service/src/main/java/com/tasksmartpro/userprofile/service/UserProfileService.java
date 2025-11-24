package com.tasksmartpro.userprofile.service;

import com.tasksmartpro.userprofile.dto.*;
import com.tasksmartpro.userprofile.entity.*;
import com.tasksmartpro.userprofile.exception.NotFoundException;
import com.tasksmartpro.userprofile.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository profileRepo;
    private final UserSettingsRepository settingsRepo;

    public UserProfileResponse create(CreateUserProfileRequest req) {

        if (profileRepo.existsById(req.getUserId())) {
            throw new RuntimeException("Profile already exists");
        }

        UserProfile profile = UserProfile.builder()
                .userId(req.getUserId())
                .fullName(req.getFullName())
                .phone(req.getPhone())
                .language(req.getLanguage())
                .timezone(req.getTimezone())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        profileRepo.save(profile);

        return toResponse(profile);
    }

    public UserProfileResponse get(Long userId) {
        UserProfile profile = profileRepo.findById(userId)
                .orElseThrow(() -> new NotFoundException("Profile not found: " + userId));

        return toResponse(profile);
    }

    public UserProfileResponse update(Long id, UpdateUserProfileRequest req) {
        UserProfile profile = profileRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Profile not found: " + id));

        profile.setFullName(req.getFullName());
        profile.setPhone(req.getPhone());
        profile.setLanguage(req.getLanguage());
        profile.setTimezone(req.getTimezone());
        profile.setUpdatedAt(LocalDateTime.now());

        profileRepo.save(profile);

        return toResponse(profile);
    }

    private UserProfileResponse toResponse(UserProfile p) {
        return UserProfileResponse.builder()
                .userId(p.getUserId())
                .fullName(p.getFullName())
                .phone(p.getPhone())
                .photoUrl(p.getPhotoUrl())
                .language(p.getLanguage())
                .timezone(p.getTimezone())
                .build();
    }
}
