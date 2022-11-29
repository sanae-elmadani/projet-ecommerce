package com.ApiGateway.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;



@RestController
public class FallbackController {

    @GetMapping(value = "/fallback")
    public ResponseEntity<Object> fallback() {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("message", "Gateway Timeout!");
        return new ResponseEntity<>(
                response,
                HttpStatus.GATEWAY_TIMEOUT
        );
    }

}