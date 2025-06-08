package com.example.spring.clientuiservice.dto.client;

import com.example.spring.clientuiservice.dto.LoginResponseDTO;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LoginClientResponseDTO {
    private String userName;
    private String userId;
    private String accessToken;
    private String refreshToken;

    public LoginResponseDTO toLoginResponseDTO() {
        return LoginResponseDTO.builder()
                .userName(userName)
                .userId(userId)
                .accessToken(accessToken)
                .build();
    }

}
