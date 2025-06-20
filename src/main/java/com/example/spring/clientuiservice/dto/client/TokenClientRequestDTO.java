package com.example.spring.clientuiservice.dto.client;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenClientRequestDTO {
    private String refreshToken;
}
