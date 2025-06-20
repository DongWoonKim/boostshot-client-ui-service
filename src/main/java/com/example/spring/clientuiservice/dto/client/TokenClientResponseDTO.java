package com.example.spring.clientuiservice.dto.client;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenClientResponseDTO {
    private int status;
    private String accessToken;
    private String refreshToken;

}
