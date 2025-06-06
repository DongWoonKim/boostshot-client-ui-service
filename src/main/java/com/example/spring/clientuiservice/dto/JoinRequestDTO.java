package com.example.spring.clientuiservice.dto;

import com.example.spring.clientuiservice.type.Role;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class JoinRequestDTO {
    private String userId;
    private String password;
    private String userName;
    private Role role;
}
