package com.example.spring.clientuiservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "postClient", url = "${services.edge-service-url}/boards")
public interface PostClient {
}
