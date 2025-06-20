package com.example.spring.clientuiservice.controller.token;

import com.example.spring.clientuiservice.dto.client.TokenClientResponseDTO;
import com.example.spring.clientuiservice.service.token.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenApiController {

    private final TokenService tokenService;

    @PostMapping("/auth/token")
    public TokenClientResponseDTO getToken(HttpServletRequest request, HttpServletResponse response) {
        return tokenService.getToken(request.getCookies());
    }

}
