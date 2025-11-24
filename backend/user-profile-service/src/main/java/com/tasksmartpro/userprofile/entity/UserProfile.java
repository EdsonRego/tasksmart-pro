package com.tasksmartpro.userprofile.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {

    @Id
    private Long userId; // mesmo ID do auth-service

    private String fullName;
    private String phone;
    private String photoUrl;
    private String language;
    private String timezone;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
