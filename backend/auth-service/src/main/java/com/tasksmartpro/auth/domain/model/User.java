package com.tasksmartpro.auth.domain.model;

import com.tasksmartpro.auth.domain.enums.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;
}
