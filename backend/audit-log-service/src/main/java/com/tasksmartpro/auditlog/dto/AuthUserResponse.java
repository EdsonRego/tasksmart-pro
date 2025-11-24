package com.tasksmartpro.auditlog.dto;

import lombok.Data;

@Data
public class AuthUserResponse {
    private Long id;
    private String name;
    private String email;
}
