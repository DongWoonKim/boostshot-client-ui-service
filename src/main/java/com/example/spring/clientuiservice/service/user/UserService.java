package com.example.spring.clientuiservice.service.user;

import com.example.spring.clientuiservice.client.AuthClient;
import com.example.spring.clientuiservice.dto.JoinRequestDTO;
import com.example.spring.clientuiservice.dto.LoginRequestDTO;
import com.example.spring.clientuiservice.dto.client.JoinClientResponseDTO;
import com.example.spring.clientuiservice.dto.client.LoginClientResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final AuthClient authClient;

    public JoinClientResponseDTO join(JoinRequestDTO joinRequestDTO) {
        return authClient.join(joinRequestDTO);
    }

    public LoginClientResponseDTO login(LoginRequestDTO requestDTO) {
        return authClient.login(requestDTO);
    }

}
