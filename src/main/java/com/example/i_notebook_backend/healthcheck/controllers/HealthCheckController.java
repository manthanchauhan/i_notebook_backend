package com.example.i_notebook_backend.healthcheck.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/healthcheck")
public class HealthCheckController {
    @GetMapping("")
    public Map<String, String> healthcheck(){
        return Collections.singletonMap("message", "Service is ready");
    }
}
