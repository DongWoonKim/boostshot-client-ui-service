package com.example.spring.clientuiservice.client;

import com.example.spring.clientuiservice.dto.JoinRequestDTO;
import com.example.spring.clientuiservice.dto.LoginRequestDTO;
import com.example.spring.clientuiservice.dto.client.JoinClientResponseDTO;
import com.example.spring.clientuiservice.dto.client.LoginClientResponseDTO;
import com.example.spring.clientuiservice.dto.client.TokenClientRequestDTO;
import com.example.spring.clientuiservice.dto.client.TokenClientResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authClient", url = "${services.edge-service-url}/auth")
public interface AuthClient {

    @PostMapping("/join")
    JoinClientResponseDTO join(@RequestBody JoinRequestDTO joinRequestDTO);

    @PostMapping("/login")
    LoginClientResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO);

    @PostMapping("/token")
    TokenClientResponseDTO token(@RequestBody TokenClientRequestDTO tokenClientRequestDTO);
}
