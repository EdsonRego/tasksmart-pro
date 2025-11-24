package com.tasksmartpro.userprofile.dto;

import lombok.Data;

@Data
public class CreateUserProfileRequest {
    private Long userId;
    private String fullName;
    private String phone;
    private String language;
    private String timezone;
}
