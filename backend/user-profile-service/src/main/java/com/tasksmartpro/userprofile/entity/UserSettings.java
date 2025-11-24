package com.tasksmartpro.userprofile.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_settings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private boolean darkMode;
    private boolean emailNotifications;
    private boolean pushNotifications;
}
