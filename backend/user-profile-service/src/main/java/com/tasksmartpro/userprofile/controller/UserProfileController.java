package com.tasksmartpro.userprofile.controller;

import com.tasksmartpro.userprofile.dto.*;
import com.tasksmartpro.userprofile.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService service;

    @PostMapping
    public ResponseEntity<UserProfileResponse> create(@RequestBody CreateUserProfileRequest req) {
        return ResponseEntity.ok(service.create(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfileResponse> update(
            @PathVariable Long id,
            @RequestBody UpdateUserProfileRequest req
    ) {
        return ResponseEntity.ok(service.update(id, req));
    }
}
