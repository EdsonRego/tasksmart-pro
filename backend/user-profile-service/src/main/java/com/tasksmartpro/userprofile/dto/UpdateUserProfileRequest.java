package com.tasksmartpro.userprofile.dto;

import lombok.Data;

@Data
public class UpdateUserProfileRequest {
    private String fullName;
    private String phone;
    private String language;
    private String timezone;
}
