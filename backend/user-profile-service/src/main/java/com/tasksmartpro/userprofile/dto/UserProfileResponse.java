package com.tasksmartpro.userprofile.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserProfileResponse {
    private Long userId;
    private String fullName;
    private String phone;
    private String photoUrl;
    private String language;
    private String timezone;
}
