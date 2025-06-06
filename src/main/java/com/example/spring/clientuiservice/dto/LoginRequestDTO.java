package com.example.spring.clientuiservice.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LoginRequestDTO {
    private String userId;
    private String password;
}
