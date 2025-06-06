package com.example.spring.clientuiservice.controller.user;

import com.example.spring.clientuiservice.dto.JoinRequestDTO;
import com.example.spring.clientuiservice.dto.JoinResponseDTO;
import com.example.spring.clientuiservice.dto.LoginRequestDTO;
import com.example.spring.clientuiservice.dto.LoginResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @PostMapping("/users")
    public JoinResponseDTO createUser(@RequestBody JoinRequestDTO joinRequestDTO) {

        System.out.println("joinRequestDTO :: " + joinRequestDTO);

        return JoinResponseDTO.builder()
                .build();
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {

        System.out.println("loginRequestDTO :: " + loginRequestDTO);

        return LoginResponseDTO.builder()
                .build();
    }

}
