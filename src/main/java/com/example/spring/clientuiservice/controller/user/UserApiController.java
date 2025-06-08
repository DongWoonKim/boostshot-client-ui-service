package com.example.spring.clientuiservice.controller.user;

import com.example.spring.clientuiservice.dto.JoinRequestDTO;
import com.example.spring.clientuiservice.dto.JoinResponseDTO;
import com.example.spring.clientuiservice.dto.LoginRequestDTO;
import com.example.spring.clientuiservice.dto.LoginResponseDTO;
import com.example.spring.clientuiservice.dto.client.LoginClientResponseDTO;
import com.example.spring.clientuiservice.service.user.UserService;
import com.example.spring.clientuiservice.util.CookieUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    @PostMapping("/users")
    public JoinResponseDTO createUser(@RequestBody JoinRequestDTO joinRequestDTO) {
        return userService.join(joinRequestDTO)
                .toJoinResponseDTO();
    }

    @PostMapping("/login")
    public LoginResponseDTO login(
            @RequestBody LoginRequestDTO loginRequestDTO,
            HttpServletResponse response
    ) {
        LoginClientResponseDTO logined = userService.login(loginRequestDTO);

        if (logined == null) {
            throw new IllegalArgumentException("로그인 실패: 사용자 정보를 찾을 수 없습니다.");
        }

        addRefreshTokenCookieIfPresent(response, logined.getRefreshToken());

        return logined.toLoginResponseDTO();
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request, HttpServletResponse response) {
        CookieUtil.deleteCookie(request, response, "refreshToken");
        return ResponseEntity.ok().build();
    }

    private void addRefreshTokenCookieIfPresent(HttpServletResponse response, String refreshToken) {
        if (refreshToken != null && !refreshToken.isBlank()) {
            CookieUtil.addCookie(response, "refreshToken", refreshToken, 7 * 24 * 60 * 60); // 7일
        }
    }

}
