package com.example.spring.clientuiservice.dto.client;

import com.example.spring.clientuiservice.dto.JoinResponseDTO;
import lombok.Getter;

@Getter
public class JoinClientResponseDTO {
    private boolean isSuccess;

    public JoinResponseDTO toJoinResponseDTO() {
        return JoinResponseDTO.builder()
                .isSuccess(isSuccess)
                .url(isSuccess ? "/boards/login" : "/boards/join")
                .build();
    }
}
