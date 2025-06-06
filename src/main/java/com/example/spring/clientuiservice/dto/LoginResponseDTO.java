package com.example.spring.clientuiservice.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponseDTO {
    private String url;
    private String userName;
    private String userId;
    private String message;
    private String accessToken;
}
