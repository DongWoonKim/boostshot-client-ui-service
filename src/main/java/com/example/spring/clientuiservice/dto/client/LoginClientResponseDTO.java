package com.example.spring.clientuiservice.dto.client;

import com.example.spring.clientuiservice.dto.LoginResponseDTO;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LoginClientResponseDTO {
    private boolean loggedIn;
    private String userName;
    private String userId;
    private String message;
    private String accessToken;
    private String refreshToken;

    public LoginResponseDTO toLoginResponseDTO() {
        return LoginResponseDTO.builder()
                .userName(userName)
                .userId(userId)
                .accessToken(accessToken)
                .url(loggedIn ? "/" : "/users/login")
                .message(loggedIn ? "로그인 성공!" : "로그인 실패!")
                .build();
    }

}
