package com.example.spring.clientuiservice.controller.user;

import com.example.spring.clientuiservice.dto.JoinRequestDTO;
import com.example.spring.clientuiservice.dto.JoinResponseDTO;
import com.example.spring.clientuiservice.dto.LoginRequestDTO;
import com.example.spring.clientuiservice.dto.LoginResponseDTO;
import com.example.spring.clientuiservice.dto.client.LoginClientResponseDTO;
import com.example.spring.clientuiservice.service.user.UserService;
import com.example.spring.clientuiservice.util.CookieUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
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
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO, HttpServletResponse response) {
        LoginClientResponseDTO logined = userService.login(loginRequestDTO);

//        if (logined != null && logined.isLoggedIn()) {
//            // Refresh Token을 HttpOnly 쿠키에 저장
//            CookieUtil.addCookie(response, "refreshToken", logined.getRefreshToken(), 7 * 24 * 60 * 60);
//        }

        assert logined != null;
        return logined.toLoginResponseDTO();
    }

}
