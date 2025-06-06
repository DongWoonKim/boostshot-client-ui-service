package com.example.spring.clientuiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ClientUiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientUiServiceApplication.class, args);
    }

}
